package com.example.composenewsapp.presentation.detail

sealed class DetailEvent {

    data object SaveArticle : DetailEvent()

}