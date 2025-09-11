package com.example.exo5tp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ForgotPasswordPage(onNavigate: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp, vertical = 150.dp)
    ) {
        Text("Récupération de mot de passe", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))

        var email by remember { mutableStateOf("") }
        TextField(value = email, onValueChange = { email = it }, placeholder = { Text("Email") }, modifier = Modifier.fillMaxWidth())

        ElevatedButton(
            onClick = { onNavigate("connexion") },
            modifier = Modifier.fillMaxWidth().padding(top = 24.dp)
        ) {
            Text("Envoyer le lien de récupération")
        }

        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = { onNavigate("connexion") }) { Text("Retour à la connexion") }
    }
}