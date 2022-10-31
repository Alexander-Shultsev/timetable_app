package com.example.timetable_compose_9901.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.timetable_compose_9901.view.screen.ChangeInTimetable.TimetableViewModel
import com.example.timetable_compose_9901.view.screen.ChangeInTimetable.WeekButtonItem
import com.example.timetable_compose_9901.view.theme.*

@Composable
fun TimetableButton(
    dayOfWeek: WeekButtonItem,
    isActive: Boolean = false,
    timetableViewModel: TimetableViewModel,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }

    if (isActive) { // должно быть одно сравнение, чтобы уменьшить нагрузку
        Box(
            modifier = modifier
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    timetableViewModel.changeCurrentDay(dayOfWeek.name)
                }
                .background(
                    dayOfWeek.color
                )
                .height(
                    heightBottomButton
                )
                .clip(Shapes.small),
            contentAlignment = Alignment.Center,
            content = {
                TitleButton(
                    text = dayOfWeek.name,
                    color = Color.White)
            }
        )
    } else {
        Box(
            modifier = modifier
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    timetableViewModel.changeCurrentDay(dayOfWeek.name)
                }
                .background(
                    dayOfWeek.colorDefault
                )
                .height(
                    heightBottomButtonNoActive
                )
                .clip(Shapes.small),
            contentAlignment = Alignment.Center,
            content = {
                TitleButton(
                    text = dayOfWeek.name,
                    color = dayOfWeek.color)
            }
        )
    }
}

@Composable
fun ButtonChangeInTimetable(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clickable { onClick() }
            .background(GrayDarkMore)
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp)
            .clip(Shapes.small),
        contentAlignment = Alignment.Center,
        content = {
            Title2(
                text = "Изменения в расписании",
                color = Color.White)
        }
    )
}

