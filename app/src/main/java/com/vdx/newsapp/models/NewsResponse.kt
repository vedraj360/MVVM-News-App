package com.vdx.newsapp.models


import com.google.gson.annotations.SerializedName
import com.vdx.newsapp.models.Article

data class NewsResponse(
    @SerializedName("articles")
    val articles: MutableList<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)