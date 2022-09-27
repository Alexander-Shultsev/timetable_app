package com.example.timetable_compose_9901.view.screen.ChangeGroup

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.timetable_compose_9901.downloadStartScreenIsSuccess
import com.example.timetable_compose_9901.timetableViewModel
import com.example.timetable_compose_9901.view.component.Title1
import com.example.timetable_compose_9901.view.component.Title2
import com.example.timetable_compose_9901.view.navigation.NavItemMain
import com.example.timetable_compose_9901.view.navigation.navigate
import com.example.timetable_compose_9901.view.theme.*
import com.example.timetable_compose_9901.viewModel.TimetableViewModel

@Composable
fun ChangeGroupScreen(
    navController: NavHostController,
) {
    val currentCourse = timetableViewModel.currentCourse

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingMain,
                    bottom = paddingMain,
                    start = paddingMain,
                    end = paddingMain
                )
        ) {
            Title1(
                text = "Выберите группу",
                modifier = Modifier.padding(bottom = paddingMain)
            )

            LazyColumn {
                currentCourse.forEach { item ->
                    item {
                        Card(
                            shape = Shapes.large,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 15.dp)
                                .clickable {
                                    navigate(navController, NavItemMain.Timetable.route)
                                    timetableViewModel.setGroup(item)
                                },
                            backgroundColor =
                                when (timetableViewModel.currentGroupString.value) {
                                    "1 course/" -> ButtonMonday
                                    "2 course/" -> ButtonTuesday
                                    "3 course/" -> ButtonWednesday
                                    "4 course/" -> ButtonThursday
                                    else -> ButtonMonday
                                }
                        ) {
                            Title2(
                                text = item,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
    downloadStartScreenIsSuccess = true
}

@Preview
@Composable
fun ChangeGroupScreenP() {
    ChangeGroupScreen(navController = rememberNavController())
}