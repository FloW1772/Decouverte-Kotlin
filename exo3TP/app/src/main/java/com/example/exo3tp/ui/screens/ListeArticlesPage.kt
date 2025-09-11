package com.example.exo3tp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListeArticlesPage(onNavigate: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp)
    ) {
        Text("Liste des articles", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(24.dp))

        // Exemple d'articles (statique pour l'instant)
        Text("📦 Article 1")
        Text("📦 Article 2")
        Text("📦 Article 3")

        Spacer(modifier = Modifier.height(24.dp))

        ElevatedButton(
            onClick = { onNavigate("connexion") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Se déconnecter")
        }
    }
}