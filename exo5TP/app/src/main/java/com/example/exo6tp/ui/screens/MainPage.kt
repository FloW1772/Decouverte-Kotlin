package com.example.exo6tp.ui.screens

import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import com.example.exo6tp.ui.screens.ListeArticlesPage

@Composable
fun MainPage() {
    var currentScreen by remember { mutableStateOf("connexion") }

    when (currentScreen) {
        "connexion" -> ConnexionPage { currentScreen = it }
        "inscription" -> InscriptionPage { currentScreen = it }
        "forgot_password" -> ForgotPasswordPage { currentScreen = it }
        "liste_articles" -> ListeArticlesPage() // <-- corrigé
    }
}
