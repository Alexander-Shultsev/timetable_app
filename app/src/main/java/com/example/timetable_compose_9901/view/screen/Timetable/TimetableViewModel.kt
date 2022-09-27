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
import com.example.timetable_compose_9901.data.*
import com.example.timetable_compose_9901.main.App
import com.example.timetable_compose_9901.view.theme.*
import java.text.SimpleDateFormat
import java.util.*

val topDownWeekArray = arrayOf(
    "Верхняя неделя",
    "Нижняя неделя",
    "",
)

/* Тип данных для кнопки дня недели */
data class WeekButtonItem (
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
    WeekButtonItem("ПТ", ButtonFriday, ButtonFridayLight)
)

class TimetableViewModel: ViewModel() {

    private val _topDownWeek: MutableLiveData<String> = MutableLiveData(topDownWeekArray[0])
    private val _zoomImage: MutableLiveData<Float> = MutableLiveData(1f)
    private val _offsetImage: MutableLiveData<Offset> = MutableLiveData(Offset.Zero)
    private val _currentWeekButton: MutableLiveData<WeekButtonItem> = MutableLiveData(weekButtons[0])
    private val _currentImage: MutableLiveData<ImageItem> = MutableLiveData(g9901[0])

    val topDownWeek: LiveData<String> = _topDownWeek
    val zoomImage: LiveData<Float> = _zoomImage
    val offsetImage: LiveData<Offset> = _offsetImage
    val currentWeekButton: LiveData<WeekButtonItem> = _currentWeekButton
    val currentImage: LiveData<ImageItem> = _currentImage

    init {
        setCurrentDay()
        setCurrentWeek()
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

    fun getCurrentGroup(group: String): Array<ImageItem> {
        return when(group) {
            "1 course/9901" -> g9901
            "1 course/9902" -> g9902
            "1 course/9903" -> g9903
            else -> arrayOf()
        }
    }

    /* Получить тип недели */
    private fun setCurrentWeek() {
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
    private fun getCurrentDate(): Int {
        return SimpleDateFormat("u").format(Date()).toInt() - 1
    }

    fun setCurrentDay() {
        val numberDayOfWeek = getCurrentDate()

        if (numberDayOfWeek in 0..4) {
            _currentWeekButton.value = weekButtons[numberDayOfWeek]
            _currentImage.value = g9901[numberDayOfWeek]
        } else {
            _currentWeekButton.value = weekButtons[0]
            _currentImage.value = g9901[0]
        }
    }

    /* Изменить текущий день недели при действии пользователя */
    fun changeCurrentDay(dayOfWeek: String) {
        for (item in g9901.indices) {
            if (g9901[item].name == dayOfWeek) {
                _currentWeekButton.value = weekButtons[item]
                _currentImage.value = g9901[item]
            }
        }
    }
}