package com.example.flow.ui.navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.di.LocalApplicationProvider
import com.example.flow.ui.di.FirstScreenComponent
import com.example.flow.ui.di.SecondScreenComponent
import com.example.main.ui.screen.FirstScreen
import com.example.main.ui.screen.SecondScreen
import com.example.navigation.NavGraphFactory

object FlowNavigationFactory :
    FirstScreenDestinationFactory,
    SecondScreenDestinationFactory,
    FlowDestinationFactory,
    NavGraphFactory {

    override fun createFlowDestination(): String =
        GRAPH_ROUTE

    override fun createFirstScreenDestination(): String =
        FIRST_SCREEN_ROUTE

    override fun createSecondScreenDestination(counter: Int): String =
        "$SECOND_SCREEN_ROUTE/$counter"

    override fun NavGraphBuilder.createNavGraph(navController: NavHostController) =
        navigation(startDestination = FIRST_SCREEN_ROUTE, route = GRAPH_ROUTE) {
            composable(
                route = FIRST_SCREEN_ROUTE
            ) { backStackEntry ->

                val firstScreenViewModelFactoryProvider = FirstScreenComponent.create(
                    application = LocalApplicationProvider.current,
                    navController = navController
                ).getViewModelFactoryProvider()

                FirstScreen(
                    viewModel(
                        factory = firstScreenViewModelFactoryProvider
                    )
                )
            }

            composable(
                route = "$SECOND_SCREEN_ROUTE/{$COUNTER_ARG}",
                arguments = listOf(navArgument(COUNTER_ARG) { type = NavType.IntType })
            ) { backStackEntry ->
                //TODO: Пробросить counter в VM через даггер

                val counter = backStackEntry.arguments?.getInt(COUNTER_ARG) as Int
                val secondScreenViewModelFactoryProvider = SecondScreenComponent.create(
                    application = LocalApplicationProvider.current,
                    navController = navController,
                    counter
                ).getViewModelFactoryProvider()


                SecondScreen(
                    viewModel(
                        factory = secondScreenViewModelFactoryProvider
                    )
                )
            }
        }

    private const val COUNTER_ARG = "counter_arg"
    private const val FIRST_SCREEN_ROUTE = "first_screen"
    private const val GRAPH_ROUTE = "flow_route"
    private const val SECOND_SCREEN_ROUTE = "second_screen"

}
