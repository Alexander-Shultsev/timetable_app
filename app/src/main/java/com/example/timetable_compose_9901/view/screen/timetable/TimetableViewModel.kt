package com.example.timetable_compose_9901.viewModel

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.compose.ui.geometry.Offset
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.timetable_compose_9901.R
import com.example.timetable_compose_9901.main.App
import com.example.timetable_compose_9901.view.theme.*
import java.text.SimpleDateFormat
import java.util.*

/* Тип дня недели */
data class DayOfWeekItem (
    val name: String,
    val color: androidx.compose.ui.graphics.Color,
    val colorDefault: androidx.compose.ui.graphics.Color,
    val image: Int
)

/* Список с информацией о каждом дне недели:
имя, цвет текста кнопки, цвет кнопки, картинка */
val timetable = arrayOf(
    DayOfWeekItem("ПН", ButtonMonday, ButtonMondayLight, R.drawable.img_monday),
    DayOfWeekItem("ВТ", ButtonTuesday, ButtonTuesdayLight, R.drawable.img_tuesday),
    DayOfWeekItem("СР", ButtonWednesday, ButtonWednesdayLight, R.drawable.img_wednesday),
    DayOfWeekItem("ЧТ", ButtonThursday, ButtonThursdayLight, R.drawable.img_thursday),
    DayOfWeekItem("ПТ", ButtonFriday, ButtonFridayLight, R.drawable.img_friday)
)

/* Тип дня недели */
val topDownWeekArray = arrayOf(
    "Верхняя неделя",
    "Нижняя неделя",
    ""
)

class TimetableViewModel: ViewModel() {

    private val _currentDay: MutableLiveData<DayOfWeekItem> = MutableLiveData(timetable[0])
    private val _topDownWeek: MutableLiveData<String> = MutableLiveData(topDownWeekArray[2])
    private val _zoomImage: MutableLiveData<Float> = MutableLiveData(1f)
    private val _offsetImage: MutableLiveData<Offset> = MutableLiveData(Offset.Zero)

    val currentDay: LiveData<DayOfWeekItem> = _currentDay
    val topDownWeek: LiveData<String> = _topDownWeek
    val zoomImage: LiveData<Float> = _zoomImage
    val offsetImage: LiveData<Offset> = _offsetImage

    init {
        getCurrentDate()
        getCurrentWeek()
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

    fun getImage(imageUri: Uri): Bitmap? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            ImageDecoder.decodeBitmap(ImageDecoder.createSource(App.applicationContext().contentResolver, imageUri))
        } else {
            MediaStore.Images.Media.getBitmap(App.applicationContext().contentResolver, imageUri)
        }
    }

    /* Получить тип недели */
    private fun getCurrentWeek() {
        val numberWeekOfYear = SimpleDateFormat("w").format(Date()).toInt() % 2

        if (numberWeekOfYear % 2 == 0) {
            _topDownWeek.postValue(topDownWeekArray[0])
        } else {
            _topDownWeek.postValue(topDownWeekArray[1])
        }

        when(numberWeekOfYear) {
            0 -> _topDownWeek.postValue(topDownWeekArray[0])
            1 -> _topDownWeek.postValue(topDownWeekArray[1])
            else -> _topDownWeek.postValue("Неделя не определена")
        }
    }

    /* Получить текущий день недели */
    private fun getCurrentDate() {
        val numberDayOfWeek = SimpleDateFormat("u").format(Date()).toInt() - 1

        if (numberDayOfWeek in 0..4) {
            _currentDay.value = timetable[numberDayOfWeek]
        } else {
            _currentDay.value = timetable[0]
        }
    }

    /* Изменить текущий день недели при действии пользователя */
    fun changeCurrentDay(dayOfWeek: String) {
        timetable.forEach { item ->
            if (item.name == dayOfWeek) {
                _currentDay.postValue(item)
            }
        }
    }
}