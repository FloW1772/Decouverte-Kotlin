package com.example.exo6tp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exo6tp.model.Article
import com.example.exo6tp.network.ArticleService
import com.example.exo6tp.network.RetrofitTools
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleViewModel : ViewModel() {
    private val service = RetrofitTools.retrofit.create(ArticleService::class.java)

    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    val articles: StateFlow<List<Article>> = _articles

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun fetchArticles() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val apiArticles = service.getArticles()
                _articles.value = apiArticles
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun removeArticle(id: Int) {
        _articles.value = _articles.value.filter { it.id != id }
    }
}
