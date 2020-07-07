package com.vdx.newsapp.ui

import com.vdx.newsapp.api.RetrofitInstance
import com.vdx.newsapp.db.ArticleDataBase
import com.vdx.newsapp.models.Article

class NewsRepository(val db: ArticleDataBase) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticle().upsert(article)

    fun getSavedNews() = db.getArticle().getAllArticles()

    suspend fun deleteArticle(delete: Article) = db.getArticle().deleteArticle(delete)


}
