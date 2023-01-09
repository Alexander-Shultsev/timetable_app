package com.example.timetable_compose_9901

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.ConfigurationCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.timetable_compose_9901.main.App
import com.example.timetable_compose_9901.view.navigation.NavHostMain
import com.example.timetable_compose_9901.view.navigation.NavItemMain
import com.example.timetable_compose_9901.view.screen.ChangeInTimetable.TimetableViewModel
import java.util.Locale

var downloadStartScreenIsSuccess: Boolean = false
lateinit var timetableViewModel: TimetableViewModel
lateinit var sharedPreferences: SharedPreferences
lateinit var sharedPreferencesEditor: SharedPreferences.Editor
lateinit var downloadService: String
lateinit var currentLocale: Locale


class MainActivity : ComponentActivity() {

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (!isGranted) {
                Toast.makeText(applicationContext, "разрешение не выдано", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        // Запросить разрешение
        requestPermissionLauncher.launch(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        // Инициализировать работу с локальным хранилищем
        sharedPreferences = App.applicationContext().getSharedPreferences("App", Context.MODE_PRIVATE)
        sharedPreferencesEditor = sharedPreferences.edit()

        // Переход на экран с splash экрана после подгрузки всего контента
        goToMainScreen()
        downloadService = DOWNLOAD_SERVICE // сервис для загрузки
        currentLocale = ConfigurationCompat.getLocales(resources.configuration)[0]!!

        setContent {
            timetableViewModel = viewModel()
            NavHostMain(
                startDestination = NavItemMain.ChangeCourse.route,
                lifecycleOwner = this
            )

//            sharedPreferencesEditor.clear().commit()

            if (sharedPreferences.getString("isLoginOne", null) != null) {
                NavHostMain(startDestination = NavItemMain.Timetable.route, lifecycleOwner = this)
            } else {
                NavHostMain(startDestination = NavItemMain.ChangeCourse.route, lifecycleOwner = this)
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