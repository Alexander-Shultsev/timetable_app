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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.timetable_compose_9901.data.g9901
import com.example.timetable_compose_9901.downloadStartScreenIsSuccess
import com.example.timetable_compose_9901.timetableViewModel
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
) {
    timetableViewModel.setCurrentDay()

    val topDownWeek = timetableViewModel.topDownWeek.observeAsState()
    val currentImage = timetableViewModel.currentImage.observeAsState()
    val currentWeekButton = timetableViewModel.currentWeekButton.observeAsState()
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

//            Box( // Контейнер для изображения
//                contentAlignment = Alignment.Center,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .weight(1f)
//                    .pointerInput(Unit) {
//                        detectTapGestures(
//                            onDoubleTap = {
//                                timetableViewModel.imageToStartScreen()
//                            }
//                        )
//                    },
//                content = { // Картинка
                    PinchImage(currentImage, timetableViewModel, modifier = Modifier.fillMaxWidth().weight(1f))
                    timetableViewModel.imageToStartScreen()
//                }
//            )

            Row( // Кнопки навигации
                modifier = Modifier
                    .height(heightBottomButton),
                verticalAlignment = Alignment.Bottom
            ) {
                weekButtons.forEach { item ->
                    TimetableButton(
                        dayOfWeek = item,
                        isActive = item.name == currentWeekButton.value!!.name,
                        timetableViewModel = timetableViewModel,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TimetableScreenP() {
    TimetableScreen(rememberNavController())
}
