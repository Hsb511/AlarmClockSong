package com.example.alarmclocksong.ui.views

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@ExperimentalFoundationApi
@Composable
fun NavigationScreen() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "alarmClockList") {
        composable(route = "alarmClockList") { AlarmClockList(navController) }
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
                backStackEntry.arguments?.getString("minutes")?.toIntOrNull()
            )
        }
    }
}
