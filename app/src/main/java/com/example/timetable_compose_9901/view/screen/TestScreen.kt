package com.example.timetable_compose_9901.view.screen

import android.content.ContentValues.TAG
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.timetable_compose_9901.downloadStartScreenIsSuccess
import com.example.timetable_compose_9901.main.App
import com.example.timetable_compose_9901.viewModel.TimetableViewModel
import java.io.InputStream


@Composable
fun TestScreen(
    navController: NavController,
    timetableViewModel: TimetableViewModel = viewModel()
) {
    downloadStartScreenIsSuccess = true

//    val resId: Int = App.applicationContext().resources.getIdentifier("img_friday.png", "drawable", App.applicationContext().packageName)
//    val image = "drawable://1 course/2781/img_friday.png".toUri()
//
//    val stream: InputStream = App.applicationContext().assets.open("img_friday.png")
//    val d = Drawable.createFromStream(stream, null)

//    val otherPath: Uri = Uri.parse("android.resource://com.example.timetable_compose_9901/drawable/img_friday.png")
//
//    Log.i(TAG, "TestScreen: $otherPath")
//
//    val image = timetableViewModel.getImage(otherPath)

//    val bitmap: Bitmap
//    if (d is BitmapDrawable) {
//        bitmap = d.bitmap
//
//        Image(
//            bitmap = bitmap.asImageBitmap(),
//            contentDescription = null,
//            modifier = Modifier.size(100.dp)
//        )
//    }
//

//    Image(
//        painter = painterResource(id = resId),
//        contentDescription = null,
//        Modifier.size(100.dp)
//    )
}