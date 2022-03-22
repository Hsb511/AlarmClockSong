package com.example.alarmclocksong.ui.extensions

fun String?.getHoursFromTime() = this?.split(":")?.get(0)?.toIntOrNull()
fun String?.getMinutesFromTime() = this?.split(":")?.get(1)?.toIntOrNull()