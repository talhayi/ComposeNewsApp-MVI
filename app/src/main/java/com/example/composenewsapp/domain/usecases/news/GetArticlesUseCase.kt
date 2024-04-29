package com.example.composenewsapp.domain.usecases.news

import com.example.composenewsapp.data.local.NewsDao
import com.example.composenewsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class GetArticlesUseCase(
    private val newsDao: NewsDao
) {
    operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticles()
    }
}