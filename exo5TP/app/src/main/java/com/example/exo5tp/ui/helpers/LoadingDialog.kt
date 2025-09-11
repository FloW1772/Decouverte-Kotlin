package com.example.exo5tp.ui.helpers

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LoadingDialog(isVisible: Boolean) {
    if (isVisible) {
        AlertDialog(
            onDismissRequest = {},
            confirmButton = {},
            title = { Text("Chargement...") },
            text = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                }
            }
        )
    }
}

annotation class LoadingDialog
