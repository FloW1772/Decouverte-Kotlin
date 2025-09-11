package com.example.exo4tp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.exo4tp.model.Article

// ViewModel qui gère la liste d'articles
class ArticleViewModel : ViewModel() {

    // Liste observable des articles
    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    val articles: StateFlow<List<Article>> = _articles

    private var nextId = 1

    // Ajouter un nouvel article
    fun addArticle(titre: String) {
        val newArticle = Article(id = nextId++, titre = titre)
        _articles.value = _articles.value + newArticle
    }

    // Supprimer un article par son id
    fun removeArticle(id: Int) {
        _articles.value = _articles.value.filter { it.id != id }
    }

    // Vider complètement la liste
    fun clearArticles() {
        _articles.value = emptyList()
        nextId = 1
    }
}