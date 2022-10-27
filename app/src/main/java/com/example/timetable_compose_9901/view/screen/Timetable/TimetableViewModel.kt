package com.example.timetable_compose_9901.viewModel

import android.Manifest
import android.app.Activity
import android.app.DownloadManager
import android.app.DownloadManager.Request
import android.app.Service
import android.content.BroadcastReceiver
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.Uri
import android.opengl.Visibility
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.compose.ui.geometry.Offset
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.timetable_compose_9901.currentLocale
import com.example.timetable_compose_9901.data.*
import com.example.timetable_compose_9901.downloadService
import com.example.timetable_compose_9901.main.App
import com.example.timetable_compose_9901.sharedPreferences
import com.example.timetable_compose_9901.view.theme.*
import org.apache.poi.hwpf.HWPFDocument
import org.apache.poi.hwpf.extractor.WordExtractor
import org.jsoup.Jsoup
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.thread

val topDownWeekArray = arrayOf(
    "Нижняя",
    "Верхняя",
    ""
)

/* Тип данных для кнопки дня недели */
data class WeekButtonItem(
    val name: String,
    val color: androidx.compose.ui.graphics.Color,
    val colorDefault: androidx.compose.ui.graphics.Color
)

/* Список с информацией о каждой кнопки дня недели:
имя, цвет текста кнопки, цвет кнопки */
val weekButtons = arrayOf(
    WeekButtonItem("ПН", ButtonMonday, ButtonMondayLight),
    WeekButtonItem("ВТ", ButtonTuesday, ButtonTuesdayLight),
    WeekButtonItem("СР", ButtonWednesday, ButtonWednesdayLight),
    WeekButtonItem("ЧТ", ButtonThursday, ButtonThursdayLight),
    WeekButtonItem("ПТ", ButtonFriday, ButtonFridayLight),
    WeekButtonItem("СБ", ButtonSaturday, ButtonSaturdayLight),
)

class TimetableViewModel : ViewModel() {

    private val _topDownWeek: MutableLiveData<String> = MutableLiveData(topDownWeekArray[2])
    private val _zoomImage: MutableLiveData<Float> = MutableLiveData(1f)
    private val _offsetImage: MutableLiveData<Offset> = MutableLiveData(Offset.Zero)
    private val _currentWeekButton: MutableLiveData<WeekButtonItem> =
        MutableLiveData(weekButtons[0])
    private val _currentGroupString: MutableLiveData<String> = MutableLiveData("")
    private val _currentImage: MutableLiveData<GroupItem> = MutableLiveData()
    private val _currentGroup: MutableLiveData<Array<GroupItem>> = MutableLiveData()
    private val _changeInTimetable: MutableLiveData<String> = MutableLiveData()
    private val _currentMonth: MutableLiveData<Int> = MutableLiveData()
    val topDownWeek: LiveData<String> = _topDownWeek

    val zoomImage: LiveData<Float> = _zoomImage
    val offsetImage: LiveData<Offset> = _offsetImage
    val currentWeekButton: LiveData<WeekButtonItem> = _currentWeekButton
    val currentImage: LiveData<GroupItem> = _currentImage
    val currentGroupString: LiveData<String> = _currentGroupString
    val currentGroup: LiveData<Array<GroupItem>> = _currentGroup
    val changeInTimetable: LiveData<String> = _changeInTimetable
    val currentMonth: LiveData<Int> = _currentMonth
    var currentCourse: Array<String> = arrayOf()

    private var currentMonthUrl: String = ""
    private var currentDayUrl: String = ""
    var currentDayWeek: Int = 0
    var currentDay: String = ""

    init {
        setCurrentWeek()
        getCurrentDateWeek()
        getCurrentMonth()
    }

    // Подгрузка изобржения из локальной папки для чтения
    private fun loadDoc(
        ourDirectory: File?,
        currentDate: String
    ): File? {
        ourDirectory?.let {
            return File(ourDirectory, "12.10.2022.doc")
        }
        return null
    }

    private val monthList = arrayOf(
        "Январь",
        "Февраль",
        "Март",
        "Апрель",
        "Май",
        "Июнь",
        "Июль",
        "Август",
        "Сентябрь",
        "Октябрь",
        "Ноябрь",
        "Декабрь"
    )

    private var monthText = listOf("")
    private var monthUrl = listOf("")

    //  Получить ссылку на текущий месяц
    private fun getMonthURL() {
        Thread {
            val url = "https://portal.novsu.ru/univer/timetable/spo/i.1473214//?id=1473211"
            val document = Jsoup.connect(url).get()
            monthText = document.select(".npe_documents_portlet tr a").text().split(" ")
            monthUrl = document.select(".npe_documents_portlet tr a").eachAttr("href")

            for (i in 0..monthText.count() step 2) {
                if (i < monthText.count()) {
                    currentMonth.value?.let {
                        if (monthText[i] == monthList[it]) {
                            currentMonthUrl = monthUrl[i]
                            getUrlOnFile()
                            return@Thread
                        }
                    }
                }
            }
        }.start()
    }

    private var dayText = listOf("")
    private var dayUrl = listOf("")

    // Получить ссылку на файл с изменением в расписании
    private fun getUrlOnFile() {
        getCurrentDate()

        Thread {
            val document = Jsoup.connect(currentMonthUrl).get()
            dayText = document.select(".npe_documents_portlet tr a").text().split(" ")
            dayUrl = document.select(".npe_documents_portlet tr a").eachAttr("href")

            currentDay = "12.10.2022"

            for (i in 0 until dayText.count()) {
                if (dayText[i] == currentDay) {
                    currentDayUrl = dayUrl[i]
                    val path = App.applicationContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)!!.path + "/12.10.2022.doc"
                    downloadFile(currentDayUrl, path)
                    return@Thread
                }
            }
        }.start()
    }


    fun downloadFile(link: String, path: String) {
        Thread {
        URL(link).openStream().use { input ->
            FileOutputStream(File(path)).use { output ->
                val result = input.copyTo(output)
                Log.i(TAG, "bite --- $result")
            }
        }
    }.start()
    }

    // https://medium.com/@aungkyawmyint_26195/downloading-file-properly-in-android-d8cc28d25aca
    // Загрузка файла из интернета
    private fun downloadFil(link: String, titleFile: String) {
        val request = Request(Uri.parse(link))
            .setTitle("$12.10.2022.doc")
            .setNotificationVisibility(Request.VISIBILITY_VISIBLE)
            .setAllowedOverMetered(true)
            .setAllowedOverRoaming(true)
            .setRequiresCharging(false)

        val downloadManager by lazy {
            App.applicationContext().getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        }
        val myDownloadId = downloadManager.enqueue(request)

        val br = object: BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                val id = intent?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
                if (id == myDownloadId) {
                    Toast.makeText(App.applicationContext(), "Download completed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

//    private fun downloadWord(link : String, title : String) {
//        val request = Request(
//            Uri.parse(link))
//            .setTitle("$title.docx")
//            .setNotificationVisibility(Request.VISIBILITY_VISIBLE)
//            .setAllowedOverMetered(true)
//
//        val dm = Activity(Context.DOWNLOAD_SERVICE) as DownloadManager
//        val myDownloadid = dm.enqueue(request)
//
//
//        registerReceiver(br, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
//    }

    // Получение разнешений для получени информции об изъменении в расписании
    fun getPermission(activity: Activity) {
        if (ContextCompat.checkSelfPermission(
                App.applicationContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            thread(start = true) { getMonthURL() }
        } else {
            val permission = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
            ActivityCompat.requestPermissions(activity, permission, 0)
        }
    }

    // Прочитать содержимое файла
    private fun readDoc() {
        val file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        loadDoc(
            ourDirectory = file,
            currentDate = currentDay
        ).let {
            try {
                // Reading it as stream
                val docStream = FileInputStream(it)
                val targetDoc = HWPFDocument(docStream)

                // creating a constructor object for extracting text from the word document
                val wordExtractor = WordExtractor(targetDoc)
                val docText = wordExtractor.text
                _changeInTimetable.value = docText
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun initTimetableScreen() {
        setCurrentGroup()
        setCurrentDay()
    }

    private fun setCurrentGroup() {
        val currentGroup = sharedPreferences.getString("isLoginOne", null)
        getCurrentGroup(currentGroup!!)
    }

    fun getCurrentGroupString(): String {
        return currentGroupString.value!!
    }

    fun setCourse(course: String) {
        _currentGroupString.value = course
        getCurrentCourse(_currentGroupString.value!!)
    }

    fun setGroup(group: String) {
        _currentGroupString.value += group
        getCurrentGroup(_currentGroupString.value!!)
    }

    /* Изменить размер картинки */
    fun setZoomImage(zoomImage: Float) {
        _zoomImage.postValue(zoomImage)
    }

    /* Изменить X, Y картинки */
    fun setOffsetImage(offsetImage: Offset) {
        _offsetImage.postValue(offsetImage)
    }

    /* Сбросить параметры масштабирования и перемещения изображения */
    fun imageToStartScreen() {
        _zoomImage.value = 1f
        _offsetImage.value = Offset.Zero
    }

    private fun getCurrentGroup(group: String) {
        _currentGroup.value = when (group) {
            "1 course/2781" -> g2781
            "1 course/2791" -> g2791
            "1 course/2792" -> g2792
            "1 course/2911" -> g2911
            "1 course/2912" -> g2912
            "1 course/2913" -> g2913
            "1 course/2921" -> g2921
            "1 course/2951" -> g2951
            "1 course/2952" -> g2952
            "1 course/2953" -> g2953
            "1 course/2981" -> g2981
            "1 course/2982" -> g2982
            "1 course/2983" -> g2983
            "1 course/2991" -> g2991
            "1 course/2992" -> g2992
            "1 course/2993" -> g2993
            "1 course/2994" -> g2994
            "1 course/2995" -> g2995
            "1 course/2996" -> g2996

            "2 course/1791" -> g1791
            "2 course/1792" -> g1792
            "2 course/1911" -> g1911
            "2 course/1912" -> g1912
            "2 course/1921" -> g1921
            "2 course/1951" -> g1951
            "2 course/1952" -> g1952
            "2 course/1981" -> g1981
            "2 course/1991" -> g1991
            "2 course/1992" -> g1992
            "2 course/1994" -> g1994

            "3 course/0901" -> g0901
            "3 course/0902" -> g0902
            "3 course/0911" -> g0911
            "3 course/0931" -> g0931
            "3 course/0932" -> g0932
            "3 course/0941" -> g0941
            "3 course/0951" -> g0951
            "3 course/0952" -> g0952

            "4 course/9901" -> g9901
            "4 course/9903" -> g9903
            "4 course/9911" -> g9911
            "4 course/9921" -> g9921
            "4 course/9931" -> g9931
            "4 course/9941" -> g9941
            "4 course/9951" -> g9951
            "4 course/9961" -> g9961
            else -> arrayOf()
        }
    }

    // Получить текущее значение курса
    private fun getCurrentCourse(course: String) {
        currentCourse = when (course) {
            "1 course/" -> GroupArray.course1
            "2 course/" -> GroupArray.course2
            "3 course/" -> GroupArray.course3
            "4 course/" -> GroupArray.course4
            else -> arrayOf()
        }
    }

    /* Получить текущий месяц */
    fun getCurrentMonth() {
        _currentMonth.value = SimpleDateFormat("M", currentLocale)
            .format(Date()).toInt() - 1
    }

    /* Получить тип недели */
    private fun setCurrentWeek() {
        val numberWeekOfYear = SimpleDateFormat("w", currentLocale)
            .format(Date()).toInt() % 2

        if (currentLocale.toString() == "ru_RU") {
            when (numberWeekOfYear) {
                0 -> _topDownWeek.postValue(topDownWeekArray[1])
                1 -> _topDownWeek.postValue(topDownWeekArray[0])
                else -> _topDownWeek.postValue("Неделя не определена")
            }
        } else {
            when (numberWeekOfYear) {
                0 -> _topDownWeek.postValue(topDownWeekArray[0])
                1 -> _topDownWeek.postValue(topDownWeekArray[1])
                else -> _topDownWeek.postValue("Неделя не определена")
            }
        }

    }

    /* Получить текущий день недели */
    private fun getCurrentDateWeek() {
        currentDayWeek = SimpleDateFormat("u", currentLocale)
            .format(Date()).toInt() - 1
    }

    /* Получить текущую дату */
    private fun getCurrentDate() {
        currentDay = SimpleDateFormat("dd.MM.yyyy", currentLocale)
            .format(Date()).toString()
    }

    /* Изменить текущий день (картику и активную кнопку) */
    private fun setCurrentDay() {
        if (currentDayWeek in 0 until 5) {
            _currentWeekButton.value = weekButtons[currentDayWeek]
            _currentImage.value = currentGroup.value!![currentDayWeek]
        } else {
            _currentWeekButton.value = weekButtons[0]
            _currentImage.value = currentGroup.value!![0]
        }
    }

    /* Изменить текущий день недели при действии пользователя */
    fun changeCurrentDay(dayOfWeek: String) {
        for (item in currentGroup.value!!.indices) {
            if (currentGroup.value!![item].name == dayOfWeek) {
                _currentWeekButton.value = weekButtons[item]
                _currentImage.value = currentGroup.value!![item]
            }
        }
    }
}