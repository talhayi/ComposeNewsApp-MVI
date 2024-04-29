package com.example.composenewsapp.domain.usecases.news

data class NewsUseCases(
    val getNewsUseCase: GetNewsUseCase,
    val searchNewsUseCase: SearchNewsUseCase,
    val deleteArticleUseCase: DeleteArticleUseCase,
    val getArticlesUseCase: GetArticlesUseCase,
    val getArticleUseCase: GetArticleUseCase,
    val upsertArticleUseCase: UpsertArticleUseCase
)