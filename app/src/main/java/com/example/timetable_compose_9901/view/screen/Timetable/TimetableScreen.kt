package com.example.timetable_compose_9901.view.screen.Timetable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.timetable_compose_9901.R
import com.example.timetable_compose_9901.currentLocale
import com.example.timetable_compose_9901.sharedPreferences
import com.example.timetable_compose_9901.timetableViewModel
import com.example.timetable_compose_9901.downloadStartScreenIsSuccess
import com.example.timetable_compose_9901.view.component.*
import com.example.timetable_compose_9901.view.navigation.NavItemMain
import com.example.timetable_compose_9901.view.navigation.navigate
import com.example.timetable_compose_9901.view.theme.*
import com.example.timetable_compose_9901.viewModel.topDownWeekArray
import com.example.timetable_compose_9901.viewModel.weekButtons
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun TimetableScreen(
    navController: NavHostController,
) {
    timetableViewModel.initTimetableScreen()

    val topDownWeek = timetableViewModel.topDownWeek.observeAsState()
    val currentImage = timetableViewModel.currentImage.observeAsState()
    val currentWeekButton = timetableViewModel.currentWeekButton.observeAsState()
    val numberWeekOfYear = SimpleDateFormat("w", currentLocale).format(Date()).toInt() % 2
    val currentGroup = sharedPreferences.getString("isLoginOne", null)!!.split("/")[1]

    // определение момента перехода на экран после подгрузки содержимого
    if (topDownWeekArray[numberWeekOfYear] == topDownWeek.value)
        downloadStartScreenIsSuccess = true

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Column {
            Row(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Card(
                    shape = RoundedCornerShape(0.dp, 20.dp, 20.dp, 0.dp),
                    backgroundColor = Color.Black,
                    modifier = Modifier,
                    border = BorderStroke(2.dp, currentWeekButton.value!!.color)
                ) {
                    TitleBig( // Номер группы
                        text = topDownWeek.value!!,
                        color = currentWeekButton.value!!.color,
                        modifier = Modifier.padding(start = paddingMain, end = paddingMain + 5.dp, top = 6.dp, bottom = 6.dp)
                    )
                }
                Card(
                    shape = RoundedCornerShape(15.dp, 0.dp, 0.dp, 15.dp),
                    backgroundColor = Color.White,
                    modifier = Modifier
                    .clickable {
                        navigate(navController, NavItemMain.ChangeCourse.route)
                    }
                ) {
                    TitleBig( // Номер группы
                        text = currentGroup,
                        color = currentWeekButton.value!!.color,
                        modifier = Modifier.padding(start = paddingMain, end = paddingMain, top = 5.dp, bottom = 5.dp)
                    )
                }
            }


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
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                PinchImage(
                    currentImage, timetableViewModel, modifier = Modifier.fillMaxWidth()
                )
                timetableViewModel.imageToStartScreen()
                ButtonChangeInTimetable(
                    onClick = {
                        navController.navigate(NavItemMain.ChangeInTimetable.route)
                    }
                )
            }


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
