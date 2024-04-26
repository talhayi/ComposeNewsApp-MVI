package com.example.composenewsapp.presentation.onboarding

sealed class OnBoardingEvent {
    data object SaveAppEntry: OnBoardingEvent()
}