package com.kospavel.sandbox.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kospavel.sandbox.network.ServerApi
import com.kospavel.sandbox.ui.main.model.MainScreenEvent
import com.kospavel.sandbox.ui.main.model.MainScreenState
import com.kospavel.sandbox.ui.main.model.MainScreenWish
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(private val api: ServerApi) : ViewModel() {

    private var timerJob: Job? = null

    private val _event = Channel<MainScreenEvent>(Channel.RENDEZVOUS)
    val event = _event.receiveAsFlow()

    private val _state = MutableStateFlow(MainScreenState("Hello sandbox!"))
    val state = _state.asStateFlow()

    fun processWish(wish: MainScreenWish) {
        when (wish) {
            is MainScreenWish.BtnClick -> reduce(wish)
        }
    }

    private fun reduce(wish: MainScreenWish.BtnClick) {
        runTimer()
        viewModelScope.launch {
            Log.i("qwerty", "request sent")
            val response = runCatching { api.testRequest() }
            Log.i("qwerty", "response == $response")
            timerJob?.cancel()
            timerJob = null
            if (response.isSuccess) {
                _state.update { it.copy(text = "Request succeed!") }
            } else {
                _state.update { it.copy(text = "Request failed :(") }
            }
            Log.i("qwerty", "done")
        }
    }

    private fun runTimer() {
        var timer = 0
        timerJob = viewModelScope.launch {
            while (true) {
                delay(1000L)
                _state.update {
                    it.copy(text = "$timer seconds passed")
                }
                timer++
            }
        }
    }

}