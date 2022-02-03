package com.example.main.viewmodel

import androidx.lifecycle.ViewModel
import com.example.flow.ui.viewmodel.navigation.SecondScreenRouter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

sealed class SecondScreenState {

    data class StartState(val counter: Int = 0) : SecondScreenState()
}

class SecondScreenViewModel @Inject constructor(
    private val router: SecondScreenRouter,
    counter: Int,
) : ViewModel() {

    private val _state = MutableStateFlow<SecondScreenState>(
        SecondScreenState.StartState(counter = counter)
    )
    val state: StateFlow<SecondScreenState> = _state

    fun increaseCounter() {
        _state.tryEmit(
            (_state.value as SecondScreenState.StartState).run {
                copy(
                    counter = counter+1
                )
            }
        )
    }

    fun back() {
        router.back()
    }
}