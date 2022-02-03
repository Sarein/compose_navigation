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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.main.viewmodel.MainScreenViewModel

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel,
) {
    Surface {
         MainScreenContent("Hello", "To next screen", viewModel::nextScreen)
    }
}

@Composable
private fun MainScreenContent(msg: String, buttonMsg: String, onRouteClick: () -> Unit) {
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
            text = msg,
        )
        Spacer(modifier = Modifier.size(10.dp))
        Button(onClick = onRouteClick) {
            Text(text = buttonMsg)
        }

    }
}