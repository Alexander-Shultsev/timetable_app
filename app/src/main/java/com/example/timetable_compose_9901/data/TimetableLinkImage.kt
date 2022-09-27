package com.example.timetable_compose_9901.data

import com.example.timetable_compose_9901.R

object GroupArray {
    val course1 = arrayOf("9901", "9902", "9903")
    val course2 = arrayOf("0901", "0903", "0905")
    val course3 = arrayOf("1901", "1903", "1905")
    val course4 = arrayOf("2901", "2903", "2905")
}

/* Тип дня недели */
data class GroupItem (
    val name: String,
    val image: Int
)

/* Список с информацией о каждом дне недели:
имя, цвет текста кнопки, цвет кнопки, картинка */
val g9901 = arrayOf(
    GroupItem("ПН", R.drawable.img_monday),
    GroupItem("ВТ", R.drawable.img_tuesday),
    GroupItem("СР", R.drawable.img_wednesday),
    GroupItem("ЧТ", R.drawable.img_thursday),
    GroupItem("ПТ", R.drawable.img_friday)
)

val g9902 = arrayOf(
    GroupItem("ПН", R.drawable.img_monday),
    GroupItem("ВТ", R.drawable.img_monday),
    GroupItem("СР", R.drawable.img_monday),
    GroupItem("ЧТ", R.drawable.img_monday),
    GroupItem("ПТ", R.drawable.img_monday)
)

val g9903 = arrayOf(
    GroupItem("ПН", R.drawable.img_wednesday),
    GroupItem("ВТ", R.drawable.img_wednesday),
    GroupItem("СР", R.drawable.img_wednesday),
    GroupItem("ЧТ", R.drawable.img_wednesday),
    GroupItem("ПТ", R.drawable.img_wednesday)
)