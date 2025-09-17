package com.example.exo6tp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exo6tp.model.Article
import com.example.exo6tp.network.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleViewModel : ViewModel() {

    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    val articles: StateFlow<List<Article>> get() = _articles

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> get() = _errorMessage

    fun loadArticles() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            try {
                val response = ApiClient.apiService.getArticles()
                _articles.value = response.articles // Ici on récupère bien la liste depuis l'objet
            } catch (e: Exception) {
                _errorMessage.value = "Erreur réseau : ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun deleteArticle(id: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                ApiClient.apiService.deleteArticle(id)
                loadArticles() // Rafraîchir la liste après suppression
            } catch (e: Exception) {
                _errorMessage.value = "Erreur suppression : ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
