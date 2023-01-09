package com.example.timetable_compose_9901.view.screen.ChangeCourse

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
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

@Composable
fun ChangeCourseScreen(
    navController: NavHostController,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Column(
            modifier = Modifier.padding(
                start = paddingMain,
                end = paddingMain,
                top = paddingMain,
                bottom = paddingMain
            )
        ) {
            Title1(
                text = "Выберите курс",
                modifier = Modifier.padding(bottom = 30.dp)
            )

            Column(modifier = Modifier
                .weight(1f)
                .fillMaxWidth()) {
                Row(modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()) {
                    Card(
                        backgroundColor = ColorMain,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .clickable {
                                timetableViewModel.setCourse("1 course/")
                                navigate(navController, NavItemMain.ChangeGroup.route)
                            },
                        shape = Shapes.large
                    ) {
                        Title2(
                            text = "1 КУРС",
                            modifier = Modifier.padding(top = 18.dp, start = 20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Card(
                        backgroundColor = ButtonTuesday,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .clickable {
                                timetableViewModel.setCourse("2 course/")
                                navigate(navController, NavItemMain.ChangeGroup.route)
                            },
                        shape = Shapes.large
                    ) {
                        Title2(
                            text = "2 КУРС",
                            modifier = Modifier.padding(top = 18.dp, start = 20.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()) {
                    Card(
                        backgroundColor = ButtonWednesday,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .clickable {
                                timetableViewModel.setCourse("3 course/")
                                navigate(navController, NavItemMain.ChangeGroup.route)
                            },
                        shape = Shapes.large
                    ) {
                        Title2(
                            text = "3 КУРС",
                            modifier = Modifier.padding(top = 18.dp, start = 20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Card(
                        backgroundColor = ButtonThursday,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .clickable {
                                timetableViewModel.setCourse("4 course/")
                                navigate(navController, NavItemMain.ChangeGroup.route)
                            },
                        shape = Shapes.large
                    ) {
                        Title2(
                            text = "4 КУРС",
                            modifier = Modifier.padding(top = 18.dp, start = 20.dp)
                        )
                    }
                }
            }
        }
    }
    downloadStartScreenIsSuccess = true
}

@Preview
@Composable
fun ChangeCourseScreenP() {
    ChangeCourseScreen(navController = rememberNavController())
}