package com.example.composenewsapp.domain.usecases

import com.example.composenewsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntryUseCase(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() : Flow<Boolean> =
        localUserManager.readAppEntry()

}