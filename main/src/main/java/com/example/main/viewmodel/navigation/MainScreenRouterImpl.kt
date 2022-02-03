package com.example.main.viewmodel.navigation

import androidx.navigation.NavController
import com.example.flow.ui.navigation.FirstScreenDestinationFactory
import com.example.flow.ui.navigation.FlowDestinationFactory
import javax.inject.Inject

class MainScreenRouterImpl @Inject constructor(
    private val navController: NavController,
    private val flowDestinationFactory: FlowDestinationFactory,
): MainScreenRouter {

    override fun toNextScreen() {
        navController.navigate(flowDestinationFactory.createFlowDestination())
    }
}

