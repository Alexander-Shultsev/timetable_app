package com.example.timetable_compose_9901.data

import com.example.timetable_compose_9901.R

object GroupArray {
    val course1 = arrayOf(
        "2781", "2791", "2792", "2911", "2912", "2913", "2921", "2951", "2952", "2953",
        "2981", "2982", "2983", "2991", "2992", "2993", "2994", "2995", "2996"
    )
    val course2 = arrayOf("1791", "1792", "1911", "1912", "1921", "1951", "1952", "1981", "1991", "1992", "1994")
    val course3 = arrayOf("0901", "0902", "0911", "0931", "0932", "0941", "0951", "0952")
    val course4 = arrayOf("9901", "9903", "9911", "9921", "9931", "9941", "9951", "9961")
}

/* Тип дня недели */
data class GroupItem (
    val name: String,
    val image: Int
)

/* Сопостовление изображений дней неддели с каждой группой */

/* 1 курс */
val g2781 = arrayOf(
    GroupItem("ПН", R.drawable.c1_2781_monday),
    GroupItem("ВТ", R.drawable.c1_2781_tuesday),
    GroupItem("СР", R.drawable.c1_2781_wednasday),
    GroupItem("ЧТ", R.drawable.c1_2781_thusday),
    GroupItem("ПТ", R.drawable.c1_2781_friday),
    GroupItem("СБ", R.drawable.img_rest)
)
val g2791 = arrayOf(
    GroupItem("ПН", R.drawable.c1_2791_monday),
    GroupItem("ВТ", R.drawable.c1_2791_tuesday),
    GroupItem("СР", R.drawable.c1_2791_wednesday),
    GroupItem("ЧТ", R.drawable.c1_2791_thursday),
    GroupItem("ПТ", R.drawable.c1_2791_friday),
    GroupItem("СБ", R.drawable.img_rest)
)
val g2792 = arrayOf(
    GroupItem("ПН", R.drawable.c1_2792_monday),
    GroupItem("ВТ", R.drawable.c1_2792_tuesday),
    GroupItem("СР", R.drawable.c1_2792_wednesday),
    GroupItem("ЧТ", R.drawable.c1_2792_thursday),
    GroupItem("ПТ", R.drawable.c1_2792_friday),
    GroupItem("СБ", R.drawable.img_rest)
)
val g2911 = arrayOf(
    GroupItem("ПН", R.drawable.c1_2911_monday),
    GroupItem("ВТ", R.drawable.c1_2911_tuesday),
    GroupItem("СР", R.drawable.c1_2911_wednesday),
    GroupItem("ЧТ", R.drawable.c1_2911_thursday),
    GroupItem("ПТ", R.drawable.c1_2911_friday),
    GroupItem("СБ", R.drawable.img_rest)
)
val g2912 = arrayOf(
    GroupItem("ПН", R.drawable.c1_2912_monday),
    GroupItem("ВТ", R.drawable.c1_2912_tuesday),
    GroupItem("СР", R.drawable.c1_2912_wednesday),
    GroupItem("ЧТ", R.drawable.c1_2912_thursday),
    GroupItem("ПТ", R.drawable.c1_2912_friday),
    GroupItem("СБ", R.drawable.c1_2912_suturday)
)
val g2913 = arrayOf(
    GroupItem("ПН", R.drawable.c1_2913_monday),
    GroupItem("ВТ", R.drawable.c1_2913_tuesday),
    GroupItem("СР", R.drawable.c1_2913_wednesday),
    GroupItem("ЧТ", R.drawable.c1_2913_thursday),
    GroupItem("ПТ", R.drawable.c1_2913_friday),
    GroupItem("СБ", R.drawable.img_rest)
)
val g2921 = arrayOf(
    GroupItem("ПН", R.drawable.c1_2921_monday),
    GroupItem("ВТ", R.drawable.c1_2921_tuesday),
    GroupItem("СР", R.drawable.c1_2921_wednesday),
    GroupItem("ЧТ", R.drawable.c1_2921_thursday),
    GroupItem("ПТ", R.drawable.c1_2921_friday),
    GroupItem("СБ", R.drawable.c1_2921_suturday),
)
val g2951 = arrayOf(
    GroupItem("ПН", R.drawable.c1_2951_monday),
    GroupItem("ВТ", R.drawable.c1_2951_tuesday),
    GroupItem("СР", R.drawable.c1_2951_wednesday),
    GroupItem("ЧТ", R.drawable.c1_2951_thursday),
    GroupItem("ПТ", R.drawable.c1_2951_friday),
    GroupItem("СБ", R.drawable.img_rest)
)
val g2952 = arrayOf(
    GroupItem("ПН", R.drawable.c1_2952_monday),
    GroupItem("ВТ", R.drawable.c1_2952_tuesday),
    GroupItem("СР", R.drawable.c1_2952_wednesday),
    GroupItem("ЧТ", R.drawable.c1_2952_thursday),
    GroupItem("ПТ", R.drawable.c1_2952_friday),
    GroupItem("СБ", R.drawable.img_rest),
)
val g2953 = arrayOf(
    GroupItem("ПН", R.drawable.c1_2953_monday),
    GroupItem("ВТ", R.drawable.c1_2953_tuesday),
    GroupItem("СР", R.drawable.c1_2953_wednesday),
    GroupItem("ЧТ", R.drawable.c1_2953_thursday),
    GroupItem("ПТ", R.drawable.c1_2953_friday),
    GroupItem("СБ", R.drawable.img_rest),
)
val g2981 = arrayOf(
    GroupItem("ПН", R.drawable.c1_2981_monday),
    GroupItem("ВТ", R.drawable.c1_2981_tuesday),
    GroupItem("СР", R.drawable.c1_2981_wednesday),
    GroupItem("ЧТ", R.drawable.c1_2981_thursday),
    GroupItem("ПТ", R.drawable.c1_2981_friday),
    GroupItem("СБ", R.drawable.img_rest),
)
val g2982 = arrayOf(
    GroupItem("ПН", R.drawable.c1_2982_monday),
    GroupItem("ВТ", R.drawable.c1_2982_tuesday),
    GroupItem("СР", R.drawable.c1_2982_wednesday),
    GroupItem("ЧТ", R.drawable.c1_2982_thursday),
    GroupItem("ПТ", R.drawable.c1_2982_friday),
    GroupItem("СБ", R.drawable.img_rest),
)
val g2983 = arrayOf(
    GroupItem("ПН", R.drawable.c1_2983_monday),
    GroupItem("ВТ", R.drawable.c1_2983_tuesday),
    GroupItem("СР", R.drawable.c1_2983_wednesday),
    GroupItem("ЧТ", R.drawable.c1_2983_thursday),
    GroupItem("ПТ", R.drawable.c1_2983_friday),
    GroupItem("СБ", R.drawable.img_rest),
)
val g2991 = arrayOf(
    GroupItem("ПН", R.drawable.c1_2991_monday),
    GroupItem("ВТ", R.drawable.c1_2991_tuesday),
    GroupItem("СР", R.drawable.c1_2991_wednesday),
    GroupItem("ЧТ", R.drawable.c1_2991_thursday),
    GroupItem("ПТ", R.drawable.c1_2991_friday),
    GroupItem("СБ", R.drawable.img_rest),
)
val g2992 = arrayOf(
    GroupItem("ПН", R.drawable.c1_2992_monday),
    GroupItem("ВТ", R.drawable.c1_2992_tuesday),
    GroupItem("СР", R.drawable.c1_2992_wednesday),
    GroupItem("ЧТ", R.drawable.c1_2992_thursday),
    GroupItem("ПТ", R.drawable.c1_2992_friday),
    GroupItem("СБ", R.drawable.img_rest),
)
val g2993 = arrayOf(
    GroupItem("ПН", R.drawable.c1_2993_monday),
    GroupItem("ВТ", R.drawable.c1_2993_tuesday),
    GroupItem("СР", R.drawable.c1_2993_wednesday),
    GroupItem("ЧТ", R.drawable.c1_2993_thursday),
    GroupItem("ПТ", R.drawable.c1_2993_friday),
    GroupItem("СБ", R.drawable.img_rest),
)
val g2994 = arrayOf(
    GroupItem("ПН", R.drawable.c1_2994_monday),
    GroupItem("ВТ", R.drawable.c1_2994_tuesday),
    GroupItem("СР", R.drawable.c1_2994_wednesday),
    GroupItem("ЧТ", R.drawable.c1_2994_thursday),
    GroupItem("ПТ", R.drawable.c1_2994_friday),
    GroupItem("СБ", R.drawable.c1_2994_suturday),
)
val g2995 = arrayOf(
    GroupItem("ПН", R.drawable.c1_2995_monday),
    GroupItem("ВТ", R.drawable.c1_2995_tuesday),
    GroupItem("СР", R.drawable.c1_2995_wednesday),
    GroupItem("ЧТ", R.drawable.c1_2995_thursday),
    GroupItem("ПТ", R.drawable.c1_2995_friday),
    GroupItem("СБ", R.drawable.img_rest)
)
val g2996 = arrayOf(
    GroupItem("ПН", R.drawable.c1_2996_monday),
    GroupItem("ВТ", R.drawable.c1_2996_tuesday),
    GroupItem("СР", R.drawable.c1_2996_wednesday),
    GroupItem("ЧТ", R.drawable.c1_2996_thursday),
    GroupItem("ПТ", R.drawable.c1_2996_friday),
    GroupItem("СБ", R.drawable.c1_2996_suturday),
)



/* 2 курс */
val g1791 = arrayOf(
    GroupItem("ПН", R.drawable.c2_1791_monday),
    GroupItem("ВТ", R.drawable.c2_1791_tuesday),
    GroupItem("СР", R.drawable.c2_1791_wednesday),
    GroupItem("ЧТ", R.drawable.c2_1791_thursday),
    GroupItem("ПТ", R.drawable.c2_1791_friday),
    GroupItem("СБ", R.drawable.c2_1791_suturday),
)
val g1792 = arrayOf(
    GroupItem("ПН", R.drawable.c2_1792_monday),
    GroupItem("ВТ", R.drawable.c2_1792_tuesday),
    GroupItem("СР", R.drawable.c2_1792_wednesday),
    GroupItem("ЧТ", R.drawable.c2_1792_thursday),
    GroupItem("ПТ", R.drawable.c2_1792_friday),
    GroupItem("СБ", R.drawable.c2_1792_suturday),
)
val g1911 = arrayOf(
    GroupItem("ПН", R.drawable.c2_1911_monday),
    GroupItem("ВТ", R.drawable.c2_1911_tuesday),
    GroupItem("СР", R.drawable.c2_1911_wednesday),
    GroupItem("ЧТ", R.drawable.c2_1911_thursday),
    GroupItem("ПТ", R.drawable.c2_1911_friday),
    GroupItem("СБ", R.drawable.c2_1911_suturday),
)
val g1912 = arrayOf(
    GroupItem("ПН", R.drawable.c2_1912_monday),
    GroupItem("ВТ", R.drawable.c2_1912_tuesday),
    GroupItem("СР", R.drawable.c2_1912_wednesday),
    GroupItem("ЧТ", R.drawable.c2_1912_thursday),
    GroupItem("ПТ", R.drawable.c2_1912_friday),
    GroupItem("СБ", R.drawable.c2_1912_suturday),
)
val g1921 = arrayOf(
    GroupItem("ПН", R.drawable.c2_1921_monday),
    GroupItem("ВТ", R.drawable.c2_1921_tuesday),
    GroupItem("СР", R.drawable.c2_1921_wednesday),
    GroupItem("ЧТ", R.drawable.c2_1921_thursday),
    GroupItem("ПТ", R.drawable.c2_1921_friday),
    GroupItem("СБ", R.drawable.img_rest)
)
val g1951 = arrayOf(
    GroupItem("ПН", R.drawable.c2_1951_monday),
    GroupItem("ВТ", R.drawable.c2_1951_tuesday),
    GroupItem("СР", R.drawable.c2_1951_wednesday),
    GroupItem("ЧТ", R.drawable.c2_1951_thursday),
    GroupItem("ПТ", R.drawable.c2_1951_friday),
    GroupItem("СБ", R.drawable.img_rest)
)
val g1952 = arrayOf(
    GroupItem("ПН", R.drawable.c2_1952_monday),
    GroupItem("ВТ", R.drawable.c2_1952_tuesday),
    GroupItem("СР", R.drawable.c2_1952_wednesday),
    GroupItem("ЧТ", R.drawable.c2_1952_thursday),
    GroupItem("ПТ", R.drawable.c2_1952_friday),
    GroupItem("СБ", R.drawable.c2_1952_suturday),
)
val g1981 = arrayOf(
    GroupItem("ПН", R.drawable.c2_1981_monday),
    GroupItem("ВТ", R.drawable.c2_1981_tuesday),
    GroupItem("СР", R.drawable.c2_1981_wednesday),
    GroupItem("ЧТ", R.drawable.c2_1981_thursday),
    GroupItem("ПТ", R.drawable.c2_1981_friday),
    GroupItem("СБ", R.drawable.c2_1981_suturday),
)
val g1991 = arrayOf(
    GroupItem("ПН", R.drawable.c2_1991_monday),
    GroupItem("ВТ", R.drawable.c2_1991_tuesday),
    GroupItem("СР", R.drawable.c2_1991_wednesday),
    GroupItem("ЧТ", R.drawable.c2_1991_thursday),
    GroupItem("ПТ", R.drawable.c2_1991_friday),
    GroupItem("СБ", R.drawable.img_rest)
)
val g1992 = arrayOf(
    GroupItem("ПН", R.drawable.c2_1992_monday),
    GroupItem("ВТ", R.drawable.c2_1992_tuesday),
    GroupItem("СР", R.drawable.c2_1992_wednesday),
    GroupItem("ЧТ", R.drawable.c2_1992_thursday),
    GroupItem("ПТ", R.drawable.c2_1992_friday),
    GroupItem("СБ", R.drawable.c2_1992_suturday),
)
val g1994 = arrayOf(
    GroupItem("ПН", R.drawable.c2_1994_monday),
    GroupItem("ВТ", R.drawable.c2_1994_tuesday),
    GroupItem("СР", R.drawable.c2_1994_wednesday),
    GroupItem("ЧТ", R.drawable.c2_1994_thursday),
    GroupItem("ПТ", R.drawable.c2_1994_friday),
    GroupItem("СБ", R.drawable.c2_1994_suturday),
)



/* 3 курс */
val g0901 = arrayOf(
    GroupItem("ПН", R.drawable.c3_0901_monday),
    GroupItem("ВТ", R.drawable.c3_0901_tuesday),
    GroupItem("СР", R.drawable.c3_0901_wednesday),
    GroupItem("ЧТ", R.drawable.c3_0901_thursday),
    GroupItem("ПТ", R.drawable.c3_0901_friday),
    GroupItem("СБ", R.drawable.img_rest)
)
val g0902 = arrayOf(
    GroupItem("ПН", R.drawable.c3_0902_monday),
    GroupItem("ВТ", R.drawable.c3_0902_tuesday),
    GroupItem("СР", R.drawable.c3_0902_wednesday),
    GroupItem("ЧТ", R.drawable.c3_0902_thursday),
    GroupItem("ПТ", R.drawable.c3_0902_friday),
    GroupItem("СБ", R.drawable.img_rest)
)
val g0911 = arrayOf(
    GroupItem("ПН", R.drawable.c3_0911_monday),
    GroupItem("ВТ", R.drawable.c3_0911_tuesday),
    GroupItem("СР", R.drawable.c3_0911_wednesday),
    GroupItem("ЧТ", R.drawable.c3_0911_thursday),
    GroupItem("ПТ", R.drawable.c3_0911_friday),
    GroupItem("СБ", R.drawable.c3_0911_suturday),
)
val g0932 = arrayOf(
    GroupItem("ПН", R.drawable.c3_0932_monday),
    GroupItem("ВТ", R.drawable.c3_0932_tuesday),
    GroupItem("СР", R.drawable.c3_0932_wednesday),
    GroupItem("ЧТ", R.drawable.c3_0932_thursday),
    GroupItem("ПТ", R.drawable.c3_0932_friday),
    GroupItem("СБ", R.drawable.img_rest)
)
val g0941 = arrayOf(
    GroupItem("ПН", R.drawable.c3_0941_monday),
    GroupItem("ВТ", R.drawable.c3_0941_tuesday),
    GroupItem("СР", R.drawable.c3_0941_wednesday),
    GroupItem("ЧТ", R.drawable.c3_0941_thursday),
    GroupItem("ПТ", R.drawable.c3_0941_friday),
    GroupItem("СБ", R.drawable.c3_0941_suturday),
)
val g0951 = arrayOf(
    GroupItem("ПН", R.drawable.c3_0951_monday),
    GroupItem("ВТ", R.drawable.c3_0951_tuesday),
    GroupItem("СР", R.drawable.c3_0951_wednesday),
    GroupItem("ЧТ", R.drawable.c3_0951_thursday),
    GroupItem("ПТ", R.drawable.c3_0951_friday),
    GroupItem("СБ", R.drawable.img_rest)
)
val g0952 = arrayOf(
    GroupItem("ПН", R.drawable.c3_0952_monday),
    GroupItem("ВТ", R.drawable.c3_0952_tuesday),
    GroupItem("СР", R.drawable.c3_0952_wednesday),
    GroupItem("ЧТ", R.drawable.c3_0952_thursday),
    GroupItem("ПТ", R.drawable.c3_0952_friday),
    GroupItem("СБ", R.drawable.img_rest)
)



/* 4 курс */
val g9901 = arrayOf(
    GroupItem("ПН", R.drawable.c4_9901_monday),
    GroupItem("ВТ", R.drawable.c4_9901_thursday),
    GroupItem("СР", R.drawable.c4_9901_wednesday),
    GroupItem("ЧТ", R.drawable.c4_9901_thursday),
    GroupItem("ПТ", R.drawable.c4_9901_friday),
    GroupItem("СБ", R.drawable.img_rest)
)
val g9903 = arrayOf(
    GroupItem("ПН", R.drawable.c4_9903_monday),
    GroupItem("ВТ", R.drawable.c4_9903_thursday),
    GroupItem("СР", R.drawable.c4_9903_wednesday),
    GroupItem("ЧТ", R.drawable.c4_9903_thursday),
    GroupItem("ПТ", R.drawable.c4_9903_friday),
    GroupItem("СБ", R.drawable.c4_9903_suturday),
)
val g9911 = arrayOf(
    GroupItem("ПН", R.drawable.c4_9911_monday),
    GroupItem("ВТ", R.drawable.c4_9911_thursday),
    GroupItem("СР", R.drawable.c4_9911_wednesday),
    GroupItem("ЧТ", R.drawable.c4_9911_thursday),
    GroupItem("ПТ", R.drawable.c4_9911_friday),
    GroupItem("СБ", R.drawable.c4_9911_suturday),
)
val g9921 = arrayOf(
    GroupItem("ПН", R.drawable.c4_9921_monday),
    GroupItem("ВТ", R.drawable.c4_9921_thursday),
    GroupItem("СР", R.drawable.c4_9921_wednesday),
    GroupItem("ЧТ", R.drawable.c4_9921_thursday),
    GroupItem("ПТ", R.drawable.c4_9921_friday),
    GroupItem("СБ", R.drawable.c4_9921_suturday),
)
val g9931 = arrayOf(
    GroupItem("ПН", R.drawable.c4_9931_monday),
    GroupItem("ВТ", R.drawable.c4_9931_thursday),
    GroupItem("СР", R.drawable.c4_9931_wednesday),
    GroupItem("ЧТ", R.drawable.c4_9931_thursday),
    GroupItem("ПТ", R.drawable.c4_9931_friday),
    GroupItem("СБ", R.drawable.c4_9931_suturday),
)
val g9941 = arrayOf(
    GroupItem("ПН", R.drawable.c4_9941_monday),
    GroupItem("ВТ", R.drawable.c4_9941_thursday),
    GroupItem("СР", R.drawable.c4_9941_wednesday),
    GroupItem("ЧТ", R.drawable.c4_9941_thursday),
    GroupItem("ПТ", R.drawable.c4_9941_friday),
    GroupItem("СБ", R.drawable.c4_9941_suturday),
)
val g9951 = arrayOf(
    GroupItem("ПН", R.drawable.c4_9951_monday),
    GroupItem("ВТ", R.drawable.c4_9951_thursday),
    GroupItem("СР", R.drawable.c4_9951_wednesday),
    GroupItem("ЧТ", R.drawable.c4_9951_thursday),
    GroupItem("ПТ", R.drawable.c4_9951_friday),
    GroupItem("СБ", R.drawable.c4_9951_suturday),
)
val g9961 = arrayOf(
    GroupItem("ПН", R.drawable.c4_9961_monday),
    GroupItem("ВТ", R.drawable.c4_9961_thursday),
    GroupItem("СР", R.drawable.c4_9961_wednesday),
    GroupItem("ЧТ", R.drawable.c4_9961_thursday),
    GroupItem("ПТ", R.drawable.c4_9961_friday),
    GroupItem("СБ", R.drawable.c4_9961_suturday),
)