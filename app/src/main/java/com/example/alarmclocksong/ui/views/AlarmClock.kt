package com.example.alarmclocksong.ui.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AlarmClock(time: String) {
    Row(modifier = Modifier.padding(8.dp, 0.dp)) {
        Text(
            text = time,
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.onBackground
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun AlarmClockPreview() {
    AlarmClock("00:00")
}