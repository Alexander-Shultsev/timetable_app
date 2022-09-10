package com.example.timetable_compose_9901

import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.timetable_compose_9901.ui.screen.TimetableScreen
import com.example.timetable_compose_9901.ui.screen.state
import com.example.timetable_compose_9901.ui.theme.TimetableTheme
import com.example.timetable_compose_9901.viewModel.TimetableViewModel
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        // Переход на главный экран после подгрузки всего контента
        goToMainScreen()

        setContent {
            TimetableTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    TimetableScreen()
                }
            }
        }
    }

    private fun goToMainScreen() {
        val content: View = findViewById(android.R.id.content)
        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    return if (state) {
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                        true
                    }
                    else false
                }
            }
        )
    }
}