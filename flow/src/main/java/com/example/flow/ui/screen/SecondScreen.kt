package com.example.main.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.main.viewmodel.SecondScreenState
import com.example.main.viewmodel.SecondScreenViewModel

@Composable
fun SecondScreen(viewModel: SecondScreenViewModel) {
        Surface {
            val viewModelState by viewModel.state.collectAsState()
            when (val state = viewModelState) {
                is SecondScreenState.StartState -> SecondScreenContent(
                    counter = state.counter,
                    onBackClick = viewModel::back,
                    onCounterClick = viewModel::increaseCounter,
                )
            }
        }
}

@Composable
private fun SecondScreenContent(
    counter: Int,
    onCounterClick: () -> Unit,
    onBackClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    ) {
        Text(
            modifier = Modifier
                .align(
                    alignment = Alignment.CenterHorizontally
                ),
            text = "Second screen of flow",
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            modifier = Modifier
                .align(
                    alignment = Alignment.CenterHorizontally
                ),
            text = "Counter: $counter",
        )
        Spacer(modifier = Modifier.size(12.dp))
        Button(onClick = onCounterClick) {
            Text(text = "Increase counter")
        }

        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = onBackClick) {
            Text(text = "Go Back")
        }
    }
}