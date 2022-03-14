package com.example.alarmclocksong.ui.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AlarmClock(time: String, enabled: Boolean) {
    Row(modifier = Modifier
        .padding(0.dp, 0.dp, 0.dp, 8.dp)
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)) {
        CustomBox {
            Text(
                modifier = Modifier.padding(16.dp, 16.dp),
                text = time,
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.primary
            )

            Switch(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(0.dp, 12.dp, 16.dp, 0.dp),
                checked = true,
                enabled = enabled,
                onCheckedChange = {}
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AlarmClockPreview() {
    AlarmClock("00:00", false)
}