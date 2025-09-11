package com.example.exo4tp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun ConnexionPage(onNavigate: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp, vertical = 100.dp)
    ) {
        Text("Connexion", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        TextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Mot de passe") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        )

        ElevatedButton(
            onClick = { onNavigate("liste_articles") },
            modifier = Modifier.fillMaxWidth().padding(top = 24.dp)
        ) {
            Text("Connexion")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = { onNavigate("inscription") }) { Text("Pas de compte ? S'inscrire") }
        TextButton(onClick = { onNavigate("forgot_password") }) { Text("Mot de passe oublié ?") }
    }
}