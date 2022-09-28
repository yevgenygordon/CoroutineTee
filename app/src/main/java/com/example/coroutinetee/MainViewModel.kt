package com.example.coroutinetee

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutinetee.data.Repository
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    val repository = Repository()

    val text = repository.text

    private val _loading = MutableLiveData<Boolean>(false)
    val loading: LiveData<Boolean>
        get() = _loading

    fun loadData() {
        viewModelScope.launch {
            _loading.value = true

            repository.loadingText()

            _loading.value = false
        }
    }

}


