package com.example.timetable_compose_9901.view.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.activity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.timetable_compose_9901.view.screen.ChangeCourse.ChangeCourseScreen
import com.example.timetable_compose_9901.view.screen.ChangeGroup.ChangeGroupScreen
import com.example.timetable_compose_9901.view.screen.ChangeInTimetable.ChangeInTimetableScreen
import com.example.timetable_compose_9901.view.screen.TestScreen
import com.example.timetable_compose_9901.view.screen.Timetable.TimetableScreen


/*  Элемнеты основной навигации */
sealed class NavItemMain(
    val route: String
) {
    object Timetable: NavItemMain("Timetable")
    object Test: NavItemMain("Test")
    object ChangeCourse: NavItemMain("ChangeCourse")
    object ChangeGroup: NavItemMain("ChangeGroup")
    object ChangeInTimetable: NavItemMain("ChangeInTimetable")
}

/* Контроллер навигации */
@Composable
fun NavHostMain(
    startDestination: String,
    activity: Activity = Activity()
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavItemMain.Timetable.route) {
            TimetableScreen(navController)
        }
        composable(NavItemMain.Test.route) {
            TestScreen(navController, activity = activity)
        }
        composable(NavItemMain.ChangeCourse.route) {
            ChangeCourseScreen(navController)
        }
        composable(NavItemMain.ChangeGroup.route) {
            ChangeGroupScreen(navController)
        }
        composable(NavItemMain.ChangeInTimetable.route) {
            ChangeInTimetableScreen(navController)
        }
    }
}

/* Навигация по экранам */
fun navigate(
    navController: NavHostController,
    screen: String
) {
    navController.navigate(screen) {
        launchSingleTop = true
        popUpTo(navController.graph.startDestinationId) {
            saveState = true
        }
        restoreState = true
    }
}