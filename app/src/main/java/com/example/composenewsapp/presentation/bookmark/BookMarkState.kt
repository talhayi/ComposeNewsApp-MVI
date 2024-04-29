package com.example.composenewsapp.presentation.bookmark

import com.example.composenewsapp.domain.model.Article

data class BookMarkState (
    val articles: List<Article> = emptyList()
)