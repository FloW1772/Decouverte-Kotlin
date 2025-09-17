package com.example.exo6tp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.exo6tp.model.Article
import com.example.exo6tp.viewmodel.ArticleViewModel

@Composable
fun ListeArticlesPage(articleViewModel: ArticleViewModel = viewModel()) {

    val articles by articleViewModel.articles.collectAsState()
    val isLoading by articleViewModel.isLoading.collectAsState()
    val errorMessage by articleViewModel.errorMessage.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = { articleViewModel.loadArticles() }
        ) {
            Text("Charger les articles")
        }

        Spacer(modifier = Modifier.height(16.dp))

        when {
            isLoading -> {
                CircularProgressIndicator()
            }
            errorMessage != null -> {
                Text(text = errorMessage ?: "", color = MaterialTheme.colorScheme.error)
            }
            else -> {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(articles) { article ->
                        ArticleCard(article = article)
                    }
                }
            }
        }
    }
}

@Composable
fun ArticleCard(article: Article) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = article.titre.ifBlank { "Sans titre" },
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Auteur : ${article.auteur.ifBlank { "Inconnu" }}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = article.contenu.ifBlank { "Pas de contenu" },
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
