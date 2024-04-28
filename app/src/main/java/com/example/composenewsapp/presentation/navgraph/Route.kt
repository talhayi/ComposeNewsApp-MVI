package com.example.composenewsapp.presentation.navgraph

sealed class Route (
    val route: String
) {
    data object OnBoardingScreen: Route(route = "onBoardingScreen")
    data object HomeScreen: Route(route = "homeScreen")
    data object DetailScreen: Route(route = "detailScreen")
    data object SearchScreen: Route(route = "searchScreen")
    data object BookmarkScreen: Route(route = "bookmarkScreen")
    data object AppStartNavigation: Route(route = "appStartNavigation")
    data object NewsNavigation: Route(route = "newsNavigation")
    data object NewsNavigatorScreen: Route(route = "newsNavigatorScreen")
}