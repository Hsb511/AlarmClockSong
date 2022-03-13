package com.example.alarmclocksong.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomBox() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colors.background, RoundedCornerShape(8.dp))) {}
}