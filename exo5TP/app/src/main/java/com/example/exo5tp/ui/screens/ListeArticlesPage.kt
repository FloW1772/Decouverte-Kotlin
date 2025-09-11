package com.example.exo5tp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.exo5tp.ui.helpers.LoadingDialog
import com.example.exo5tp.viewmodel.ArticleViewModel

@Composable
fun ListeArticlesPage(onNavigate: (String) -> Unit, articleViewModel: ArticleViewModel = viewModel()) {
    val articles by articleViewModel.articles.collectAsState()
    val isLoading by articleViewModel.isLoading.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp)
    ) {
        Text("Liste des articles", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(24.dp))

        articles.forEach { article ->
            Column(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                Text(article.titre ?: "Sans titre", style = MaterialTheme.typography.titleLarge)
                Text("Auteur : ${article.auteur ?: "Inconnu"}", style = MaterialTheme.typography.bodySmall)
                Text(article.contenu ?: "Pas de contenu", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { articleViewModel.removeArticle(article.id) }) {
                    Text("❌ Supprimer")
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        ElevatedButton(
            onClick = { articleViewModel.fetchArticles() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("📡 Charger depuis l'API")
        }

        Spacer(modifier = Modifier.height(16.dp))

        ElevatedButton(
            onClick = { onNavigate("connexion") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Se déconnecter")
        }
    }

    // Popup chargement
    LoadingDialog(isVisible = isLoading)
}
