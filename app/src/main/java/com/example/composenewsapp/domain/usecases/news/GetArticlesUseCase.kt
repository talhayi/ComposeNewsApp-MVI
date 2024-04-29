package com.example.composenewsapp.domain.usecases.news

import com.example.composenewsapp.domain.model.Article
import com.example.composenewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetArticlesUseCase(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(): Flow<List<Article>> {
        return newsRepository.getArticles()
    }
}