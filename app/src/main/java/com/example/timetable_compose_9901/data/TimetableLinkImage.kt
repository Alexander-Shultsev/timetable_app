package com.example.timetable_compose_9901.data

import com.example.timetable_compose_9901.R
import com.example.timetable_compose_9901.view.theme.*

/* Тип дня недели */
data class ImageItem (
    val name: String,
    val image: Int
)

/* Список с информацией о каждом дне недели:
имя, цвет текста кнопки, цвет кнопки, картинка */
val g9901 = arrayOf(
    ImageItem("ПН", R.drawable.img_monday),
    ImageItem("ВТ", R.drawable.img_tuesday),
    ImageItem("СР", R.drawable.img_wednesday),
    ImageItem("ЧТ", R.drawable.img_thursday),
    ImageItem("ПТ", R.drawable.img_friday)
)

val g9902 = arrayOf(
    ImageItem("ПН", R.drawable.img_monday),
    ImageItem("ВТ", R.drawable.img_tuesday),
    ImageItem("СР", R.drawable.img_wednesday),
    ImageItem("ЧТ", R.drawable.img_thursday),
    ImageItem("ПТ", R.drawable.img_friday)
)

val g9903 = arrayOf(
    ImageItem("ПН", R.drawable.img_monday),
    ImageItem("ВТ", R.drawable.img_tuesday),
    ImageItem("СР", R.drawable.img_wednesday),
    ImageItem("ЧТ", R.drawable.img_thursday),
    ImageItem("ПТ", R.drawable.img_friday)
)