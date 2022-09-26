package com.example.timetable_compose_9901.view.screen.ChangeCurrentCourse

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.timetable_compose_9901.downloadStartScreenIsSuccess
import com.example.timetable_compose_9901.view.component.Title1
import com.example.timetable_compose_9901.view.theme.ColorMain
import com.example.timetable_compose_9901.view.theme.paddingMain
import com.example.timetable_compose_9901.viewModel.TimetableViewModel
import com.example.timetable_compose_9901.viewModel.topDownWeekArray
import kotlin.math.log

@Composable
fun ChangeCourseScreen(
    navController: NavController,
    viewModel: TimetableViewModel
) {
    downloadStartScreenIsSuccess = true
    val topDownWeek = viewModel.topDownWeek.observeAsState(topDownWeekArray[2])

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Column {
            Title1(
                topDownWeek.value,
                modifier = Modifier.padding(start = paddingMain, end = paddingMain, top = paddingMain)
            )

            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 128.dp),
                content = {
                    for(i in 0 until 4) {
                        item {
                            Card(
                                modifier = Modifier.background(ColorMain)
                            ) {
                                Text(text = "1 курс", color = Color.White)
                            }
                        }
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun ChangeCourseScreenP() {
}