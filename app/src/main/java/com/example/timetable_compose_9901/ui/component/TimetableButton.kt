package com.example.timetable_compose_9901.ui.component

import android.view.MotionEvent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColor
import com.example.timetable_compose_9901.ui.theme.*
import com.example.timetable_compose_9901.viewModel.TimetableViewModel

//@Composable
//fun TimetableButton(
//    dayOfWeek: TimetableViewModel.DayOfWeekItem,
//    isActive: Boolean = false,
//    timetableViewModel: TimetableViewModel,
//    modifier: Modifier = Modifier,
//) {
//    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
//        Button(
//            onClick = {
//                timetableViewModel.changeCurrentDay(dayOfWeek.name)
//            },
//            colors =
//                if (isActive) {
//                    ButtonDefaults.buttonColors(dayOfWeek.color)
//                } else {
//                    ButtonDefaults.buttonColors(
//                        backgroundColor = Color(
//                            dayOfWeek.color.red,
//                            dayOfWeek.color.green,
//                            dayOfWeek.color.blue, .3f
//                        )
//                    )
//                },
//            shape = RoundedCornerShape(0.dp),
//            modifier = modifier
//                .height( if (isActive) heightBottomButton else heightBottomButtonNoActive),
//            content = {
//                TitleButton(
//                    text = dayOfWeek.name,
//                    color = if (isActive) Color.White else dayOfWeek.color)
//            }
//        )
//    }
//}

@Composable
fun TimetableButton(
    dayOfWeek: TimetableViewModel.DayOfWeekItem,
    isActive: Boolean = false,
    timetableViewModel: TimetableViewModel,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = modifier
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                timetableViewModel.changeCurrentDay(dayOfWeek.name)
            }
            .background(
                if (isActive) dayOfWeek.color else dayOfWeek.colorDefault
            )
            .height(
                if (isActive) heightBottomButton else heightBottomButtonNoActive
            )
            .clip(Shapes.small),
        contentAlignment = Alignment.Center,
        content = {
            TitleButton(
                text = dayOfWeek.name,
                color = if (isActive) Color.White else dayOfWeek.color)
        }
    )
}

