package com.example.demoandroid.exo_1

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
import com.example.demoandroid.demo_2.TemplatePage
import com.example.demoandroid.ui.theme.DemoAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoAndroidTheme {
                // Choisis l’écran que tu veux tester :
                ConnexionPage()
                // InscriptionPage()
                // ForgotPasswordPage()
            }
        }
    }
}

/* ----------------------------- ÉCRAN CONNEXION ----------------------------- */
@Composable
fun ConnexionPage() {
    TemplatePage {
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
        }
    }
}

/* ----------------------------- ÉCRAN INSCRIPTION ----------------------------- */
@Composable
fun InscriptionPage() {
    TemplatePage {
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
            var codePostal by remember { mutableStateOf("") }
            var ville by remember { mutableStateOf("") }
            var telephone by remember { mutableStateOf("") }

            TextField(value = pseudo, onValueChange = { pseudo = it }, placeholder = { Text("Pseudo") }, modifier = Modifier.fillMaxWidth())
            TextField(value = email, onValueChange = { email = it }, placeholder = { Text("Email") }, modifier = Modifier.fillMaxWidth().padding(top = 8.dp))
            TextField(value = password, onValueChange = { password = it }, placeholder = { Text("Mot de passe") }, visualTransformation = PasswordVisualTransformation(), modifier = Modifier.fillMaxWidth().padding(top = 8.dp))
            TextField(value = confirmPassword, onValueChange = { confirmPassword = it }, placeholder = { Text("Confirmation Mot de passe") }, visualTransformation = PasswordVisualTransformation(), modifier = Modifier.fillMaxWidth().padding(top = 8.dp))
            TextField(value = codePostal, onValueChange = { codePostal = it }, placeholder = { Text("Code Postal") }, modifier = Modifier.fillMaxWidth().padding(top = 8.dp))
            TextField(value = ville, onValueChange = { ville = it }, placeholder = { Text("Ville") }, modifier = Modifier.fillMaxWidth().padding(top = 8.dp))
            TextField(value = telephone, onValueChange = { telephone = it }, placeholder = { Text("N° Téléphone") }, modifier = Modifier.fillMaxWidth().padding(top = 8.dp))

            ElevatedButton(
                onClick = { /* TODO: Action Inscription */ },
                modifier = Modifier.fillMaxWidth().padding(top = 24.dp)
            ) {
                Text("S'inscrire")
            }
        }
    }
}

/* ----------------------------- ÉCRAN MOT DE PASSE OUBLIÉ ----------------------------- */
@Composable
fun ForgotPasswordPage() {
    TemplatePage {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 40.dp, vertical = 150.dp)
        ) {
            Text("Récupération de mot de passe", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(24.dp))

            var email by remember { mutableStateOf("") }

            TextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )

            ElevatedButton(
                onClick = { /* TODO: Envoyer lien */ },
                modifier = Modifier.fillMaxWidth().padding(top = 24.dp)
            ) {
                Text("Envoyer le lien de récupération")
            }
        }
    }
}

/* ----------------------------- PREVIEWS ----------------------------- */
@Preview(showBackground = true)
@Composable
fun ConnexionPreview() {
    DemoAndroidTheme { ConnexionPage() }
}

@Preview(showBackground = true)
@Composable
fun InscriptionPreview() {
    DemoAndroidTheme { InscriptionPage() }
}

@Preview(showBackground = true)
@Composable
fun ForgotPasswordPreview() {
    DemoAndroidTheme { ForgotPasswordPage() }
}
