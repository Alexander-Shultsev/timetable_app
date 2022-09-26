package com.example.timetable_compose_9901.view.screen

import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.timetable_compose_9901.view.component.PinchImage
import com.example.timetable_compose_9901.view.component.TimetableButton
import com.example.timetable_compose_9901.view.component.Title1
import com.example.timetable_compose_9901.view.navigation.NavItemMain
import com.example.timetable_compose_9901.view.theme.heightBottomButton
import com.example.timetable_compose_9901.view.theme.paddingMain
import com.example.timetable_compose_9901.viewModel.TimetableViewModel
import com.example.timetable_compose_9901.viewModel.timetable
import com.example.timetable_compose_9901.viewModel.topDownWeekArray
import java.text.SimpleDateFormat
import java.util.*


@Composable
fun ChangeCurrentCourseScreen(
    navController: NavController,
    timetableViewModel: TimetableViewModel = viewModel()
) {
    val topDownWeek = timetableViewModel.topDownWeek.observeAsState()
}