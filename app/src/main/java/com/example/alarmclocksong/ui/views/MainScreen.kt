package com.example.alarmclocksong.ui.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.alarmclocksong.ui.viewmodels.AlarmClockListVM

@ExperimentalFoundationApi
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val alarmClockListVM = AlarmClockListVM()
    
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.surface)) {
        NavHost(navController, startDestination = "alarmClockList") {
            composable(route = "alarmClockList") { AlarmClockList(navController, alarmClockListVM) }
            composable(
                route = "timePicker/{id}?hours={hours}?minutes={minutes}",
                arguments = listOf(
                    navArgument("id") { },
                    navArgument("hours") { },
                    navArgument("minutes") { })
            ) { backStackEntry ->
                TimePicker(
                    navController,
                    backStackEntry.arguments?.getString("id")!!.toInt(),
                    backStackEntry.arguments?.getString("hours")?.toIntOrNull(),
                    backStackEntry.arguments?.getString("minutes")?.toIntOrNull(),
                    alarmClockListVM
                )
            }
        }
    }
}
