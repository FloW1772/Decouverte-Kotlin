package com.example.demoandroid.demo_mvvm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class CounterViewModel : ViewModel() {

    // Compteur entier ECOUTABLE
    var counter = MutableStateFlow<Int>(1)

    fun incrementCounter(){
        counter.value += 1
    }
}