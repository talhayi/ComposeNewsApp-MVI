package com.example.composenewsapp.data.remote.dto

import com.example.composenewsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)