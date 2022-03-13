package com.example.alarmclocksong.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AlarmClock(time: String) {
    Row(modifier = Modifier
        .padding(0.dp, 0.dp, 0.dp, 8.dp)
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background, RoundedCornerShape(16.dp))) {
            Text(
                modifier = Modifier.padding(8.dp, 16.dp),
                text = time,
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.primary
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AlarmClockPreview() {
    AlarmClock("00:00")
}