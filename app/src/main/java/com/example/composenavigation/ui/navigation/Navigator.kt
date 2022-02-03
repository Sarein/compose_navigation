package com.example.composenavigation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.flow.ui.navigation.FlowNavigationFactory
import com.example.main.navigation.MainScreenNavigationFactory

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = MainScreenNavigationFactory.createMainScreenDestination()
    ) {

        with(MainScreenNavigationFactory) {
            createNavGraph(navController)
        }

        with(FlowNavigationFactory) {
            createNavGraph(navController)
        }
    }
}