package com.example.main.navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.di.LocalApplicationProvider
import com.example.main.di.MainScreenComponent
import com.example.main.ui.screen.MainScreen
import com.example.navigation.NavGraphFactory

object MainScreenNavigationFactory : MainScreenDestinationFactory, NavGraphFactory {

    override fun createMainScreenDestination(): String =
        MAIN_SCREEN_ROUTE

    override fun NavGraphBuilder.createNavGraph(navController: NavHostController) =
        composable(MAIN_SCREEN_ROUTE) { backStackEntry ->

            val viewModelProvider = MainScreenComponent.create(
                LocalApplicationProvider.current,
                navController
            ).getViewModelFactoryProvider()

            MainScreen(viewModel(factory = viewModelProvider))
        }

    private val MAIN_SCREEN_ROUTE = "main_screen"
}