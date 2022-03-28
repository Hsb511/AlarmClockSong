package com.example.alarmclocksong.ui.extensions

fun Int?.toReadableTime() = this?.let {if (it < 10) "0$it" else "$it"} ?:"00"