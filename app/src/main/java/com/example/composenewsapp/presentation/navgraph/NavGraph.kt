package com.example.composenewsapp.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.composenewsapp.presentation.bookmark.BookMarkScreen
import com.example.composenewsapp.presentation.bookmark.BookMarkViewModel
import com.example.composenewsapp.presentation.onboarding.OnBoardingScreen
import com.example.composenewsapp.presentation.onboarding.OnBoardingViewModel
import com.example.composenewsapp.presentation.search.SearchScreen
import com.example.composenewsapp.presentation.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {

        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(event = viewModel::onEvent)
                /*event = {
                            viewModel.onEvent(it)
                        }*/
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {
            composable(route = Route.NewsNavigatorScreen.route) {
                val viewModel: BookMarkViewModel = hiltViewModel()
                BookMarkScreen(
                    state = viewModel.state.value,
                    navigateToDetails = {}
                )
            }
            composable(route = Route.SearchScreen.route) {

            }
            composable(route = Route.BookmarkScreen.route) {

            }
            composable(route = Route.DetailScreen.route) {

            }
        }
    }
}