package com.example.exo5tp.ui.screens

import androidx.compose.runtime.*
import androidx.compose.runtime.Composable

@Composable
fun MainPage() {
    var currentScreen by remember { mutableStateOf("connexion") }

    when (currentScreen) {
        "connexion" -> ConnexionPage { currentScreen = it }
        "inscription" -> InscriptionPage { currentScreen = it }
        "forgot_password" -> ForgotPasswordPage { currentScreen = it }
        "liste_articles" -> ListeArticlesPage(onNavigate = { currentScreen = it })
    }
}
