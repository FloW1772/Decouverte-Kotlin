package com.example.exo5tp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*   // ✅ remplace "Composable" par "*" pour inclure collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel   // ✅ indispensable
import com.example.exo5tp.viewmodel.ArticleViewModel

@Composable
fun ListeArticlesPage(onNavigate: (String) -> Unit, articleViewModel: ArticleViewModel = viewModel()) {
    val articles by articleViewModel.articles.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp)
    ) {
        Text("Liste des articles", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(24.dp))

        // Affichage dynamique avec bouton suppression
        articles.forEach { article ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("📦 ${article.titre}")
                TextButton(onClick = { articleViewModel.removeArticle(article.id) }) {
                    Text("❌ Supprimer")
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        ElevatedButton(
            onClick = { articleViewModel.addArticle("Article de test") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ajouter un article")
        }

        Spacer(modifier = Modifier.height(16.dp))

        ElevatedButton(
            onClick = { onNavigate("connexion") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Se déconnecter")
        }
    }
}