package io.github.zero918nobita.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    private val event = Channel<Unit>(Channel.BUFFERED)

    private val textStateFlow = MutableStateFlow("Hello, world!")
    init {
        event.receiveAsFlow().onEach {
            textStateFlow.value = repository.getStr()
        }.launchIn(viewModelScope)
    }
    val text: Flow<String> get() = textStateFlow

    fun updateText() {
        viewModelScope.launch {
            event.send(Unit)
        }
    }
}
