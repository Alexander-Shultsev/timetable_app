package com.example.timetable_compose_9901.viewModel

import android.content.ContentValues.TAG
import android.graphics.Color
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.material.ButtonColors
import androidx.compose.runtime.MutableState
import androidx.compose.ui.geometry.Offset
import androidx.core.graphics.toColor
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.timetable_compose_9901.R
import com.example.timetable_compose_9901.ui.theme.*
import java.text.SimpleDateFormat
import java.util.*

val timetable = arrayOf(
    TimetableViewModel.DayOfWeekItem("ПН", ButtonMonday, ButtonMondayLight, R.drawable.img_monday),
    TimetableViewModel.DayOfWeekItem("ВТ", ButtonTuesday, ButtonTuesdayLight, R.drawable.img_tuesday),
    TimetableViewModel.DayOfWeekItem("СР", ButtonWednesday, ButtonWednesdayLight, R.drawable.img_wednesday),
    TimetableViewModel.DayOfWeekItem("ЧТ", ButtonThursday, ButtonThursdayLight, R.drawable.img_thursday),
    TimetableViewModel.DayOfWeekItem("ПТ", ButtonFriday, ButtonFridayLight, R.drawable.img_friday)
)

val topDownWeekArray = arrayOf(
    "Верхняя неделя",
    "Нижняя неделя",
    ""
)

class TimetableViewModel: ViewModel() {

    data class DayOfWeekItem (
        val name: String,
        val color: androidx.compose.ui.graphics.Color,
        val colorDefault: androidx.compose.ui.graphics.Color,
        val image: Int
    )

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

    fun setZoomImage(zoomImage: Float) {
        _zoomImage.postValue(zoomImage)
    }

    fun setOffsetImage(offsetImage: Offset) {
        _offsetImage.postValue(offsetImage)
    }

    fun getCurrentWeek() {
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

    private fun getCurrentDate() {
        val numberDayOfWeek = SimpleDateFormat("u").format(Date()).toInt() - 1

        if (numberDayOfWeek in 0..4) {
            _currentDay.postValue(timetable[numberDayOfWeek])
        } else {
            _currentDay.postValue(timetable[0])
        }
    }

    fun changeCurrentDay(dayOfWeek: String) {
        timetable.forEach { item ->
            if (item.name == dayOfWeek) {
                _currentDay.postValue(item)
            }
        }
    }

    fun imageToStartScreen() {
        _zoomImage.value = 1f
        _offsetImage.value = Offset.Zero
    }
}