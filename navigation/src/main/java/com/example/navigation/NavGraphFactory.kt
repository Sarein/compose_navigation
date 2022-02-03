package com.example.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

interface NavGraphFactory {

    fun NavGraphBuilder.createNavGraph(navController: NavHostController)
}