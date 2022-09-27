package com.example.timetable_compose_9901.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.timetable_compose_9901.view.screen.ChangeCurrentCourse.ChangeCourseScreen
import com.example.timetable_compose_9901.view.screen.TestScreen
import com.example.timetable_compose_9901.view.screen.Timetable.TimetableScreen


/*  Элемнеты основной навигации */
sealed class NavItemMain(
    val route: String
) {
    object Timetable: NavItemMain("Timetable")
    object Test: NavItemMain("Test")
    object ChangeCourse: NavItemMain("ChangeCourse")
}

/* Контроллер навигации */
@Composable
fun NavHostMain() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavItemMain.ChangeCourse.route
    ) {
        composable(NavItemMain.Timetable.route) {
            TimetableScreen(navController)
        }
        composable(NavItemMain.Test.route) {
            TestScreen(navController)
        }
        composable(NavItemMain.ChangeCourse.route) {
            ChangeCourseScreen(navController)
        }
    }
}