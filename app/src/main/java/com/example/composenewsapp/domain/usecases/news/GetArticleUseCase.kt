package com.example.composenewsapp.domain.usecases.news

import com.example.composenewsapp.domain.model.Article
import com.example.composenewsapp.domain.repository.NewsRepository

class GetArticleUseCase (
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(url: String): Article?{
        return newsRepository.getArticle(url = url)
    }
}