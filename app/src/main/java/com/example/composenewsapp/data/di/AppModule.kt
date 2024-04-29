package com.example.composenewsapp.data.di

import android.app.Application
import androidx.room.Room
import com.example.composenewsapp.data.local.NewsDao
import com.example.composenewsapp.data.local.NewsDatabase
import com.example.composenewsapp.data.local.NewsTypeConvertor
import com.example.composenewsapp.data.manager.LocalUserManagerImpl
import com.example.composenewsapp.data.remote.NewsApi
import com.example.composenewsapp.data.repository.NewsRepositoryImpl
import com.example.composenewsapp.domain.manager.LocalUserManager
import com.example.composenewsapp.domain.repository.NewsRepository
import com.example.composenewsapp.domain.usecases.app_entry.AppEntryUseCase
import com.example.composenewsapp.domain.usecases.app_entry.ReadAppEntryUseCase
import com.example.composenewsapp.domain.usecases.app_entry.SaveAppEntryUseCase
import com.example.composenewsapp.domain.usecases.news.GetNews
import com.example.composenewsapp.domain.usecases.news.NewsUseCases
import com.example.composenewsapp.domain.usecases.news.SearchNews
import com.example.composenewsapp.util.Constants.BASE_URL
import com.example.composenewsapp.util.Constants.NEWS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManager
    ): AppEntryUseCase = AppEntryUseCase(
        readAppEntryUseCase = ReadAppEntryUseCase(localUserManger),
        saveAppEntryUseCase = SaveAppEntryUseCase(localUserManger)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDao
    ): NewsRepository = NewsRepositoryImpl(newsApi, newsDao)

    @Provides
    @Singleton
    fun provideNewsUseCase(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao
}