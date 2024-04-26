package com.example.composenewsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.example.composenewsapp.domain.usecases.AppEntryUseCase
import com.example.composenewsapp.presentation.onboarding.OnBoardingScreen
import com.example.composenewsapp.presentation.onboarding.OnBoardingViewModel
import com.example.composenewsapp.ui.theme.ComposeNewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var appEntryUseCase: AppEntryUseCase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()
        lifecycleScope.launch {
            appEntryUseCase.readAppEntryUseCase().collect{
                Log.e("Test", it.toString())
            }
        }
        setContent {
            ComposeNewsAppTheme {
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {

                    val viewModel: OnBoardingViewModel = hiltViewModel()
                    OnBoardingScreen(
                        event = viewModel::onEvent
                        /*event = {
                            viewModel.onEvent(it)
                        }*/
                    )
                }
            }
        }
    }
}