package com.example.exo4tp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun InscriptionPage(onNavigate: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp, vertical = 50.dp)
    ) {
        Text("Inscription", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))

        var pseudo by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var confirmPassword by remember { mutableStateOf("") }

        TextField(value = pseudo, onValueChange = { pseudo = it }, placeholder = { Text("Pseudo") }, modifier = Modifier.fillMaxWidth())
        TextField(value = email, onValueChange = { email = it }, placeholder = { Text("Email") }, modifier = Modifier.fillMaxWidth().padding(top = 8.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Mot de passe") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
        )
        TextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            placeholder = { Text("Confirmation Mot de passe") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
        )

        ElevatedButton(
            onClick = { onNavigate("liste_articles") },
            modifier = Modifier.fillMaxWidth().padding(top = 24.dp)
        ) {
            Text("S'inscrire")
        }

        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = { onNavigate("connexion") }) { Text("Déjà un compte ? Se connecter") }
    }
}
