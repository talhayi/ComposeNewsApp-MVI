package com.example.composenewsapp.domain.usecases.app_entry

import com.example.composenewsapp.domain.manager.LocalUserManager

class SaveAppEntryUseCase(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}