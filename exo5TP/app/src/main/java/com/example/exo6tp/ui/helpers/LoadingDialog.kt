package com.example.exo6tp.ui.helpers

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp   // 👈 ICI l'import manquant
import androidx.compose.ui.window.Dialog

@Composable
fun LoadingDialog(isVisible: Boolean) {
    if (isVisible) {
        Dialog(onDismissRequest = { }) {
            Surface(
                shape = MaterialTheme.shapes.medium,
                tonalElevation = 8.dp
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(24.dp)
                )
            }
        }
    }
}
