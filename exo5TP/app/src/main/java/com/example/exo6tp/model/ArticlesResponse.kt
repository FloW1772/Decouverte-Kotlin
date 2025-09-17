package com.example.exo6tp.model

import com.google.gson.annotations.SerializedName

data class ArticlesResponse(
    @SerializedName("articles") val articles: List<Article>
)
