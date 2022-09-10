package com.example.timetable_compose_9901.ui.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timetable_compose_9901.ui.theme.jost

@Composable
fun Title1(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = TextStyle(
            fontFamily = jost,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.White),
        modifier = modifier)
}

@Composable
fun TitleButton(
    text: String,
    modifier: Modifier = Modifier,
    color: Color
) {
    Text(
        text = text,
        style = TextStyle(
            fontFamily = jost,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 2.sp,
            fontSize = 22.sp,
            color = color),
        modifier = modifier)
}



