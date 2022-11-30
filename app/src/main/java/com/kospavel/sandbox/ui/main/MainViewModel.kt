package com.kospavel.sandbox.ui.main

import androidx.lifecycle.ViewModel
import com.kospavel.sandbox.ui.main.model.MainScreenEvent
import com.kospavel.sandbox.ui.main.model.MainScreenState
import com.kospavel.sandbox.ui.main.model.MainScreenWish
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow

class MainViewModel : ViewModel() {

    private val _event = Channel<MainScreenEvent>(Channel.RENDEZVOUS)
    val event = _event.receiveAsFlow()

    private val _state = MutableStateFlow(MainScreenState("Hello sandbox!"))
    val state = _state.asStateFlow()

    fun processWish(wish: MainScreenWish) {

    }

}