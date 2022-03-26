package com.example.alarmclocksong.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alarmclocksong.ui.extensions.switchColors

@Composable
fun AlarmClock(time: String, enabled: Boolean, modifier: Modifier = Modifier) {
    val mRemember = remember { mutableStateOf(enabled) }

    Row(modifier = Modifier
            .padding(0.dp, 0.dp, 0.dp, 8.dp)
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        AlarmClockBox(modifier = modifier) {
            Text(
                text = time,
                style = MaterialTheme.typography.h4,
                color = mRemember.value.switchColors(
                    MaterialTheme.colors.primary,
                    MaterialTheme.colors.primaryVariant
                ),
                modifier = Modifier.padding(16.dp, 16.dp)
            )

            Switch(
                checked = mRemember.value,
                onCheckedChange = { mRemember.value = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = MaterialTheme.colors.primary),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(0.dp, 12.dp, 16.dp, 0.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AlarmClockPreview() {
    AlarmClock("00:00", false)
}