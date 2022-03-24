package com.example.alarmclocksong.ui.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@ExperimentalFoundationApi
@Composable
fun NavigationScreen() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "alarmClockList") {
        composable(route = "alarmClockList") { AlarmClockList(navController) }
        composable(route = "timePicker") { TimePicker(navController) }
    }
}
