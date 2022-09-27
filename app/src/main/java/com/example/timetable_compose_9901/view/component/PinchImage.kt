package com.example.timetable_compose_9901.view.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import com.example.timetable_compose_9901.data.GroupItem
import com.example.timetable_compose_9901.viewModel.TimetableViewModel

@Composable
fun PinchImage(
    currentDay: State<GroupItem?>,
    timetableViewModel: TimetableViewModel
) {
    val zoom = timetableViewModel.zoomImage.observeAsState(1f)
    val offset = timetableViewModel.offsetImage.observeAsState(Offset.Zero)

    Image(
        painter = painterResource(currentDay.value!!.image),
        contentDescription = null,
        modifier = Modifier
            .pointerInput(Unit) {
                detectTransformGestures(
                    onGesture = { gestureCentroid, gesturePan, gestureZoom, _ ->
                        val newScale = (zoom.value * gestureZoom).coerceIn(1f..3f)

                        if (zoom.value != 1f) {
                            timetableViewModel.setOffsetImage(
                                (offset.value + gestureCentroid / zoom.value) -
                                        (gestureCentroid / newScale + gesturePan / zoom.value)
                            )
                        }
                        timetableViewModel.setZoomImage(newScale)
                    }
                )
            }
            .graphicsLayer {
                if (zoom.value != 1f) {
                    translationY = -offset.value.y * zoom.value
                    translationX = -offset.value.x * zoom.value
                }
                scaleX = zoom.value
                scaleY = zoom.value
                TransformOrigin(0f, 0f).also { transformOrigin = it }
            })
}