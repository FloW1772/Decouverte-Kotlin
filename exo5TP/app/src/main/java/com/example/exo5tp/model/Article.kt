package com.example.exo5tp.model

import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("idArticle") val id: Int,
    @SerializedName("titre") val titre: String?,
    @SerializedName("contenu") val contenu: String?,
    @SerializedName("auteur") val auteur: String?
)
