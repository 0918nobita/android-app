package io.github.zero918nobita.myapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.zero918nobita.myapplication.repository.MainRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {
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
