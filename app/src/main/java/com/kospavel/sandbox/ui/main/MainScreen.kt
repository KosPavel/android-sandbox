package com.kospavel.sandbox.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kospavel.sandbox.ui.main.model.MainScreenState
import com.kospavel.sandbox.ui.main.model.MainScreenWish
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun MainScreen() {

    val vm = getViewModel<MainViewModel>()

    LaunchedEffect(key1 = Unit) {
        vm.event.collectLatest {

        }
    }

    val state by vm.state.collectAsStateWithLifecycle()
    MainScreenWithState(state) { vm.processWish(MainScreenWish.BtnClick) }
}

@Composable
fun MainScreenWithState(
    state: MainScreenState,
    onBtnClick: () -> Unit
) {
    with(state) {
        Column {
            Text(text = text)
            Button(onClick = { onBtnClick.invoke() }) {
                Text("Сделать запрос")
            }
        }
    }
}