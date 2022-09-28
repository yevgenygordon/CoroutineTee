package com.example.coroutinetee.data


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay


class Repository {

    private val _text = MutableLiveData<String>()
    val text: LiveData<String>
        get() = _text

    suspend fun loadingText() {

        for (i in 10 downTo 1) {
            _text.value = i.toString()
            delay(800)
        }

        delay(3000)
        _text.value = "Indische Tee"
    }

}
