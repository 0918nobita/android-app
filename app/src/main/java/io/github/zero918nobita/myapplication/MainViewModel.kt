package io.github.zero918nobita.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    private val event = Channel<Unit>(Channel.BUFFERED)

    @OptIn(ExperimentalCoroutinesApi::class)
    val text = event.receiveAsFlow().flatMapLatest {
        flow {
            emit(repository.getStr())
        }
    }

    fun updateText() {
        viewModelScope.launch {
            event.send(Unit)
        }
    }
}
