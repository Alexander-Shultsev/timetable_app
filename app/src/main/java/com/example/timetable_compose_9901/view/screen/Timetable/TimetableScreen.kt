package com.example.timetable_compose_9901.view.screen.Timetable

import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.timetable_compose_9901.data.g9901
import com.example.timetable_compose_9901.downloadStartScreenIsSuccess
import com.example.timetable_compose_9901.view.component.PinchImage
import com.example.timetable_compose_9901.view.component.TimetableButton
import com.example.timetable_compose_9901.view.component.Title1
import com.example.timetable_compose_9901.view.theme.*
import com.example.timetable_compose_9901.viewModel.TimetableViewModel
import com.example.timetable_compose_9901.viewModel.topDownWeekArray
import com.example.timetable_compose_9901.viewModel.weekButtons
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun TimetableScreen(
    navController: NavController,
    viewModel: TimetableViewModel = viewModel()
) {
    val topDownWeek = viewModel.topDownWeek.observeAsState()
    val currentGroup = viewModel.getCurrentGroup("1 course/9901")
    val currentWeekButton = viewModel.currentWeekButton.observeAsState()
    val currentImage = viewModel.currentImage.observeAsState(g9901[0])
    val numberWeekOfYear = SimpleDateFormat("w").format(Date()).toInt() % 2

    if (topDownWeekArray[numberWeekOfYear] == topDownWeek.value)
        downloadStartScreenIsSuccess = true

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title1( // Верхняя/нижняя неделя
                text = topDownWeek.value!!,
                modifier = Modifier
                    .padding(top = 40.dp)
            )

            Box( // Контейнер для изображения
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .weight(1f)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onDoubleTap = {
                                viewModel.imageToStartScreen()
                            }
                        )
                    },
                content = { // Картинка
                    PinchImage(currentImage, viewModel)
                    viewModel.imageToStartScreen()
                }
            )

            Row( // Кнопки навигации
                modifier = Modifier
                    .height(heightBottomButton),
                verticalAlignment = Alignment.Bottom
            ) {
                weekButtons.forEach { item ->
                    TimetableButton(
                        dayOfWeek = item,
                        isActive = item.name == currentImage.value.name,
                        timetableViewModel = viewModel,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}