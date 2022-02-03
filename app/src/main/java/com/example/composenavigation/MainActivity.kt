package com.example.composenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.rememberNavController
import com.example.composenavigation.ui.navigation.Navigation
import com.example.composenavigation.ui.theme.ComposeNavigationTheme
import com.example.di.LocalApplicationProvider
import com.example.main.viewmodel.MainScreenViewModel

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeNavigationTheme {
                CompositionLocalProvider(
                    LocalApplicationProvider provides application
                ) {
                    val navController = rememberNavController()
                    Navigation(navController)
                }
            }
        }
    }
}