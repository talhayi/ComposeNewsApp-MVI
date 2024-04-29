package com.example.composenewsapp.domain.usecases.news

import com.example.composenewsapp.domain.model.Article
import com.example.composenewsapp.domain.repository.NewsRepository

class DeleteArticleUseCase (
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(article: Article){
        newsRepository.deleteArticle(article = article)
    }
}