package io.github.zero918nobita.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    private val event = MutableSharedFlow<Unit>()

    @OptIn(ExperimentalCoroutinesApi::class)
    val text: Flow<String> =
        event
            .flatMapLatest { flow { emit(repository.getStr()) } }
            .stateIn(viewModelScope, SharingStarted.Lazily, "Hello, world!")

    fun updateText() {
        viewModelScope.launch { event.emit(Unit) }
    }
}
