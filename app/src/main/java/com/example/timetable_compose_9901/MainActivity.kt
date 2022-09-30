package com.example.timetable_compose_9901

import android.content.ContentValues.TAG
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.format.Time
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.content.SharedPreferencesCompat
import androidx.core.content.edit
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.timetable_compose_9901.main.App
import com.example.timetable_compose_9901.view.navigation.NavHostMain
import com.example.timetable_compose_9901.view.navigation.NavItemMain
import com.example.timetable_compose_9901.view.theme.TimetableTheme
import com.example.timetable_compose_9901.viewModel.TimetableViewModel

var downloadStartScreenIsSuccess: Boolean = false
lateinit var timetableViewModel: TimetableViewModel
lateinit var sharedPreferences: SharedPreferences
lateinit var sharedPreferencesEditor: SharedPreferences.Editor

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        sharedPreferences = App.applicationContext().getSharedPreferences("App", Context.MODE_PRIVATE)
        sharedPreferencesEditor = sharedPreferences.edit()

        // Переход на экран с splash экрана после подгрузки всего контента
        goToMainScreen()

        setContent {
            timetableViewModel = viewModel()
            NavHostMain(startDestination = NavItemMain.ChangeCourse.route)

//            sharedPreferencesEditor.clear().commit()

            if (sharedPreferences.getString("isLoginOne", null) != null) {
                NavHostMain(startDestination = NavItemMain.Timetable.route)
            } else {
                NavHostMain(startDestination = NavItemMain.ChangeCourse.route)
            }
        }
    }

    // Переход на главный экран после подгрузки всего контента
    private fun goToMainScreen() {
        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    return if (downloadStartScreenIsSuccess) {
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                        true
                    }
                    else false
                }
            }
        )
    }
}