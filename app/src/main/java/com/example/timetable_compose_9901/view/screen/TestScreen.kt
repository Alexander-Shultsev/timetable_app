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
import com.example.timetable_compose_9901.viewModel.TimetableViewModel
import org.apache.poi.xwpf.extractor.XWPFWordExtractor
import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.apache.poi.
import java.io.File
import java.io.FileInputStream
import java.io.InputStream


@Composable
fun TestScreen(
    navController: NavController,
    timetableViewModel: TimetableViewModel = viewModel(),
    activity: Activity = Activity()
) {
    downloadStartScreenIsSuccess = true

    getPermission(activity)
}


private fun getPermission(activity: Activity) {
    if (ContextCompat.checkSelfPermission(App.applicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
        == PackageManager.PERMISSION_GRANTED
    ) {
        readDoc()
    } else {
        val permission = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
        ActivityCompat.requestPermissions(activity, permission, 0)
    }
}

private fun loadDoc(ourDirectory: File): File? {
    ourDirectory.let {
        var retrievedDoc = File(ourDirectory, "10.10.2022.doc")
        return retrievedDoc
    }
}

private fun readDoc() {
    loadDoc(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)).let {
        Log.i(TAG, "readDoc: $it")
        try {
            //Reading it as stream
            val docStream = FileInputStream(it)
            val targetDoc = XWPFDocument(docStream)

            //creating a constructor object for extracting text from the word document
            val wordExtractor = XWPFWordExtractor(targetDoc)
            val docText = wordExtractor.text
            Log.i(TAG, "readDoc: $docText")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}