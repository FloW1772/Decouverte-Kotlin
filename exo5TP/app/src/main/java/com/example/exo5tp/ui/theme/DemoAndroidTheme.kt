package com.example.exo5tp.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun DemoAndroidTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) darkColorScheme() else lightColorScheme()

    MaterialTheme(
        colorScheme = colors,
        typography = Typography(),
        content = content
    )
}