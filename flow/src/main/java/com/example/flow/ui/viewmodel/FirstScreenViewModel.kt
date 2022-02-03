package com.example.main.viewmodel

import androidx.lifecycle.ViewModel
import com.example.flow.ui.viewmodel.navigation.FirstScreenRouter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

sealed class FirstScreenState {

    data class StartState(val counter: Int = 0) : FirstScreenState()
}

class FirstScreenViewModel @Inject constructor(
    private val firstScreenRouter: FirstScreenRouter,
): ViewModel() {

    private val _state = MutableStateFlow<FirstScreenState>(
        FirstScreenState.StartState()
    )
    val state: StateFlow<FirstScreenState> = _state

    fun nextScreen() {
        firstScreenRouter.openSecondScreen((_state.value as FirstScreenState.StartState).counter)
    }

    fun increaseCounter() {
        _state.tryEmit(
            (_state.value as FirstScreenState.StartState).run {
                copy(
                    counter = counter+1
                )
            }
        )
    }

    fun back() {
        firstScreenRouter.back()
    }
}