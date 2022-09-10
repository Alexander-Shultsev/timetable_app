package com.example.timetable_compose_9901.ui.screen

import android.util.DisplayMetrics
import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.timetable_compose_9901.ui.component.PinchImage
import com.example.timetable_compose_9901.ui.component.TimetableButton
import com.example.timetable_compose_9901.ui.component.Title1
import com.example.timetable_compose_9901.ui.theme.TimetableTheme
import com.example.timetable_compose_9901.ui.theme.heightBottomButton
import com.example.timetable_compose_9901.viewModel.TimetableViewModel
import com.example.timetable_compose_9901.viewModel.timetable
import com.example.timetable_compose_9901.viewModel.topDownWeekArray
import java.text.SimpleDateFormat
import java.util.*

var state: Boolean = false

@Composable
fun TimetableScreen(timetableViewModel: TimetableViewModel = viewModel()) {
    val topDownWeek = timetableViewModel.topDownWeek.observeAsState()
    val currentDay = timetableViewModel.currentDay.observeAsState()
    val numberWeekOfYear = SimpleDateFormat("w").format(Date()).toInt() % 2

    if (topDownWeekArray[numberWeekOfYear] == topDownWeek.value) state = true

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Title1( // Верхняя/нижняя неделя
            text = topDownWeek.value!!,
            modifier = Modifier
                .padding(top = 40.dp))

        Box( // Контейнер для изображения
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(1f)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onDoubleTap = {
                            timetableViewModel.imageToStartScreen()
                        }
                    )
                },
            content = { // Картинка
                PinchImage(currentDay, timetableViewModel)
                timetableViewModel.imageToStartScreen()
            }
        )

        Row( // Кнопки навигации
            modifier = Modifier
                .height(heightBottomButton),
            verticalAlignment = Alignment.Bottom
        ) {
            timetable.forEach { item ->
                TimetableButton(
                    dayOfWeek = item,
                    isActive = item.name == currentDay.value!!.name,
                    timetableViewModel = timetableViewModel,
                    modifier = Modifier.weight(1f))
            }
        }
    }
}