package com.example.exo6tp.network

import com.example.exo6tp.model.Article
import retrofit2.http.GET

interface ArticleService {
    @GET("articles.json")
    suspend fun getArticles(): List<Article>
}
