package com.example.composenewsapp.domain.usecases.news

import androidx.paging.PagingData
import com.example.composenewsapp.domain.model.Article
import com.example.composenewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow


class SearchNewsUseCase(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.searchNews(
            searchQuery = searchQuery,
            sources = sources
        )
    }
}