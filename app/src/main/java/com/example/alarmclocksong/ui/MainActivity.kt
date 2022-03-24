package com.example.alarmclocksong.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import com.example.alarmclocksong.ui.theme.ACSTheme
import com.example.alarmclocksong.ui.views.NavigationScreen

class MainActivity: ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { ACSTheme { NavigationScreen() } }
    }
}