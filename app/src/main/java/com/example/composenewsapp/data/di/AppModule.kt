package com.example.composenewsapp.data.di

import android.app.Application
import com.example.composenewsapp.data.manager.LocalUserManagerImpl
import com.example.composenewsapp.domain.manager.LocalUserManager
import com.example.composenewsapp.domain.usecases.app_entry.AppEntryUseCase
import com.example.composenewsapp.domain.usecases.app_entry.ReadAppEntryUseCase
import com.example.composenewsapp.domain.usecases.app_entry.SaveAppEntryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
}