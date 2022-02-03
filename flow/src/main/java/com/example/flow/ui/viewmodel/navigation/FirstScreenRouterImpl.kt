package com.example.flow.ui.viewmodel.navigation

import androidx.navigation.NavController
import com.example.flow.ui.navigation.SecondScreenDestinationFactory
import javax.inject.Inject

class FirstScreenRouterImpl @Inject constructor(
    private val navController: NavController,
    private val secondScreenDestinationFactory: SecondScreenDestinationFactory,
) : FirstScreenRouter {

    override fun openSecondScreen(counter: Int) {
        navController.navigate(
            route = secondScreenDestinationFactory.createSecondScreenDestination(counter)
        )
    }

    override fun back() {
        navController.popBackStack()
    }
}