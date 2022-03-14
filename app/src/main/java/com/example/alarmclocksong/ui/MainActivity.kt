package com.example.alarmclocksong.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.alarmclocksong.ui.theme.ACSTheme
import com.example.alarmclocksong.ui.views.AlarmClockList

class MainActivity:  ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { ACSTheme { AlarmClockList() } }
    }
}