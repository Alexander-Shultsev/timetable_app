package com.example.timetable_compose_9901.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.timetable_compose_9901.view.screen.TestScreen
import com.example.timetable_compose_9901.view.screen.TimetableScreen


/*  Элемнеты основной навигации */
sealed class NavItemMain(
    val route: String
) {
    object Timetable: NavItemMain("Timetable")
    object Test: NavItemMain("Test")
}

/* Контроллер навигации */
@Composable
fun NavHostMain() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavItemMain.Timetable.route
    ) {
        composable(NavItemMain.Timetable.route) {
            TimetableScreen(navController)
        }
        composable(NavItemMain.Test.route) {
            TestScreen(navController)
        }
    }
}