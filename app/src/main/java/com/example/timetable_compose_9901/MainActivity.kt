package com.example.timetable_compose_9901

import android.os.Bundle
import android.text.format.Time
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.timetable_compose_9901.view.navigation.NavHostMain
import com.example.timetable_compose_9901.view.theme.TimetableTheme
import com.example.timetable_compose_9901.viewModel.TimetableViewModel

var downloadStartScreenIsSuccess: Boolean = false
lateinit var timetableViewModel: TimetableViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        // Переход на главный экран после подгрузки всего контента
        goToMainScreen()

        setContent {
            timetableViewModel = viewModel()
            NavHostMain()
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