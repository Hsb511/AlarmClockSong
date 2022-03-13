package com.example.alarmclocksong.ui.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.alarmclocksong.ui.theme.ACSTheme

@Composable
fun AlarmClockList(times: List<String>) {
    ACSTheme {
        LazyColumn {
            items(times) {
                AlarmClock(it)
            }
        }

        Text(text = "+")
    }
}

@Preview(showSystemUi = true)
@Composable
fun AlarmClockListPreview() {
    ACSTheme {
        LazyColumn {
            items(listOf("23:23", "00:23", "23:00", "00:00")) {
                AlarmClock(it)
            }
        }

        Text(text = "+")
    }
}

