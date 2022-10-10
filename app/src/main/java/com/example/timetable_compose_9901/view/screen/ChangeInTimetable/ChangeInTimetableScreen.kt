package com.example.timetable_compose_9901.view.screen.ChangeInTimetable

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.pm.PackageManager
import android.os.Environment
import android.util.Log
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.timetable_compose_9901.downloadStartScreenIsSuccess
import com.example.timetable_compose_9901.main.App
import com.example.timetable_compose_9901.timetableViewModel
import com.example.timetable_compose_9901.viewModel.TimetableViewModel
import org.apache.poi.hwpf.HWPFDocument
import org.apache.poi.hwpf.extractor.WordExtractor
import java.io.File
import java.io.FileInputStream

@Composable
fun ChangeInTimetableScreen(
    navController: NavController,
    activity: Activity = Activity()
) {
    val changeInTimetable = timetableViewModel.changeInTimetable.observeAsState("")
    downloadStartScreenIsSuccess = true

    timetableViewModel.getPermission(activity)
    Text(changeInTimetable.value)
}