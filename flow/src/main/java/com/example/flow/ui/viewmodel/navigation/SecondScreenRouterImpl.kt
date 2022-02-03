package com.example.flow.ui.viewmodel.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.flow.ui.navigation.FirstScreenDestinationFactory
import javax.inject.Inject

class SecondScreenRouterImpl @Inject constructor(
    private val navController: NavController,
    private val firstScreenDestinationFactory: FirstScreenDestinationFactory,
) : SecondScreenRouter {

    override fun back() {
        navController.navigate(firstScreenDestinationFactory.createFirstScreenDestination()) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
        }
    }
}