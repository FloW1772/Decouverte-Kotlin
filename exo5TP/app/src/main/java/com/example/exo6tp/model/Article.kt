package com.example.exo6tp.model

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val titre: String,
    @SerializedName("content") val contenu: String,
    @SerializedName("author") val auteur: String
)
