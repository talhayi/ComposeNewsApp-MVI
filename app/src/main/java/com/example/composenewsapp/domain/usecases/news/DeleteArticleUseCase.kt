package com.example.composenewsapp.domain.usecases.news

import com.example.composenewsapp.data.local.NewsDao
import com.example.composenewsapp.domain.model.Article

class DeleteArticleUseCase (
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(article: Article){
        newsDao.delete(article = article)
    }
}