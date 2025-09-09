package com.example.exo1tp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoAndroidTheme {
                MainPage()
            }
        }
    }
}

/* ------------------ THEME ------------------ */
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

/* ------------------ MAIN PAGE ------------------ */
@Composable
fun MainPage() {
    var currentScreen by remember { mutableStateOf("connexion") }

    when (currentScreen) {
        "connexion" -> ConnexionPage { currentScreen = it }
        "inscription" -> InscriptionPage { currentScreen = it }
        "forgot_password" -> ForgotPasswordPage { currentScreen = it }
    }
}

/* ------------------ ÉCRAN CONNEXION ------------------ */
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )

        ElevatedButton(
            onClick = { /* TODO: Action Connexion */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        ) {
            Text("Connexion")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = { onNavigate("inscription") }) { Text("Pas de compte ? S'inscrire") }
        TextButton(onClick = { onNavigate("forgot_password") }) { Text("Mot de passe oublié ?") }
    }
}

/* ------------------ ÉCRAN INSCRIPTION ------------------ */
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
            onClick = { /* TODO: Action Inscription */ },
            modifier = Modifier.fillMaxWidth().padding(top = 24.dp)
        ) {
            Text("S'inscrire")
        }

        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = { onNavigate("connexion") }) { Text("Déjà un compte ? Se connecter") }
    }
}

/* ------------------ ÉCRAN MOT DE PASSE OUBLIÉ ------------------ */
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
            onClick = { /* TODO: Envoyer lien */ },
            modifier = Modifier.fillMaxWidth().padding(top = 24.dp)
        ) {
            Text("Envoyer le lien de récupération")
        }

        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = { onNavigate("connexion") }) { Text("Retour à la connexion") }
    }
}

/* ------------------ PREVIEWS ------------------ */
@Preview(showBackground = true)
@Composable
fun PreviewConnexionPage() {
    DemoAndroidTheme {
        ConnexionPage(onNavigate = {})
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInscriptionPage() {
    DemoAndroidTheme {
        InscriptionPage(onNavigate = {})
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewForgotPasswordPage() {
    DemoAndroidTheme {
        ForgotPasswordPage(onNavigate = {})
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainPage() {
    DemoAndroidTheme {
        MainPage()
    }
}
