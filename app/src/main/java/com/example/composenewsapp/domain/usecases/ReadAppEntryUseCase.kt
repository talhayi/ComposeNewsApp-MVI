package com.example.composenewsapp.domain.usecases

import com.example.composenewsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntryUseCase(
    private val localUserManager: LocalUserManager
) {
   operator fun invoke() : Flow<Boolean> =
        localUserManager.readAppEntry()
}