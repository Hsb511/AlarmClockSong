package com.example.alarmclocksong.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
inline fun AlarmClockBox(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.TopStart,
    propagateMinConstraints: Boolean = false,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colors.background,
                shape = RoundedCornerShape(24.dp)
            ),
        contentAlignment = contentAlignment,
        propagateMinConstraints = propagateMinConstraints,
        content = content
    )
}

@Preview
@Composable
fun CustomBoxPreview() {
    AlarmClockBox {
        AlarmClock(time = "00:00", enabled = false)
    }
}