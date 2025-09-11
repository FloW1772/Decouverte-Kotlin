package com.example.articlelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

// -----------------------------
// 1) Modèle de données
// -----------------------------
data class Article(
    val title: String,
    val desc: String,
    val imgPath: String // peut être une URL (ex: "https://...") ou "" si pas d'image
)

// -----------------------------
// 2) Quelques données d'exemple
// -----------------------------
val sampleArticles = listOf(
    Article(
        title = "Compose Basics",
        desc = "Apprenez les bases de Jetpack Compose pour créer des interfaces modernes.",
        imgPath = "https://developer.android.com/images/brand/Android_Robot.png"
    ),
    Article(
        title = "Kotlin Coroutines",
        desc = "Comprendre l'asynchrone en Kotlin avec les coroutines.",
        imgPath = "https://kotlinlang.org/assets/images/open-graph/kotlin_250x250.png"
    ),
    Article(
        title = "Architecture MVVM",
        desc = "Structurer vos projets Android avec le pattern MVVM.",
        imgPath = "" // pas d'image pour cet article
    )
)

// -----------------------------
// 3) Composable : un seul article
// -----------------------------
@Composable
fun ArticleItem(article: Article, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (article.imgPath.isNotBlank()) {
                AsyncImage(
                    model = article.imgPath,
                    contentDescription = article.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Photo,
                        contentDescription = "Pas d'image",
                        modifier = Modifier.size(48.dp)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

            Text(
                text = article.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = article.desc,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

// -----------------------------
// 4) Composable : écran liste (utilise items())
// -----------------------------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleListScreen(articles: List<Article>) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Liste des articles") }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            items(articles) { article ->
                ArticleItem(article = article)
            }
        }
    }
}

// -----------------------------
// 5) MainActivity : point d'entrée
// -----------------------------
@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArticleListScreen(articles = sampleArticles)
                }
            }
        }
    }
}

// -----------------------------
// 6) Preview pour l'IDE
// -----------------------------
@Preview(showBackground = true, showSystemUi = false)
@Composable
fun PreviewArticleList() {
    MaterialTheme {
        ArticleListScreen(articles = sampleArticles)
    }
}
