package io.github.zero918nobita.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    val text = MutableLiveData("Hello, world!")

    fun updateText() {
        viewModelScope.launch {
            text.value = repository.getStr()
        }
    }
}
