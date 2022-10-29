package com.example.timetable_compose_9901.view.screen.ChangeInTimetable

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.pm.PackageManager
import android.os.Environment
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.timetable_compose_9901.downloadStartScreenIsSuccess
import com.example.timetable_compose_9901.main.App
import com.example.timetable_compose_9901.timetableViewModel
import com.example.timetable_compose_9901.view.component.Title2
import com.example.timetable_compose_9901.viewModel.TimetableViewModel
import org.apache.poi.hwpf.HWPFDocument
import org.apache.poi.hwpf.extractor.WordExtractor
import java.io.File
import java.io.FileInputStream

@Composable
fun ChangeInTimetableScreen(
    navController: NavController,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        val text = "Если в течении 5 секунд расписание не появится, значит изменений на завтра нет, в этом случае нажмите кнопку назад"
        val changeInTimetable = timetableViewModel.changeInTimetable.observeAsState(text)

        timetableViewModel.getChangeInTimetable()

        LazyColumn {
            item {
                Title2(
                    text = changeInTimetable.value,
                    color = Color.White
                )
            }
        }
    }
}