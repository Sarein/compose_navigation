package com.example.main.viewmodel

import androidx.lifecycle.ViewModel
import com.example.main.viewmodel.navigation.MainScreenRouter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val router: MainScreenRouter
) : ViewModel() {

    fun nextScreen() {
        router.toNextScreen()
    }
}