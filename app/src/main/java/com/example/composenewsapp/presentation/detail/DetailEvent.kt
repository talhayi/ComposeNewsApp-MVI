package com.example.composenewsapp.presentation.detail

import com.example.composenewsapp.domain.model.Article

sealed class DetailEvent {

    data class UpsertDeleteArticle(val article: Article) : DetailEvent()
    data object RemoveSideEffect : DetailEvent()
}