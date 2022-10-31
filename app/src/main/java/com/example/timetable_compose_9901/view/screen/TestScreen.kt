package com.example.timetable_compose_9901.view.screen

import android.Manifest
import android.app.Activity
import android.content.ContentValues.TAG
import android.content.pm.PackageManager
import android.os.Environment
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.timetable_compose_9901.downloadStartScreenIsSuccess
import com.example.timetable_compose_9901.main.App
import com.example.timetable_compose_9901.view.screen.ChangeInTimetable.TimetableViewModel
import org.apache.poi.hwpf.extractor.WordExtractor
import org.apache.poi.hwpf.HWPFDocument
import java.io.File
import java.io.FileInputStream
import java.io.InputStream


@Composable
fun TestScreen(
    navController: NavController,
    timetableViewModel: TimetableViewModel = viewModel(),
) {
    downloadStartScreenIsSuccess = true
}