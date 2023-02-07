package com.plcoding.daggerhiltcourse.module2

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Singleton

class SessionTimer {

    private var isRunning = false
    var sessionTime = 0

    // spustit casovac
    fun startTimer() {
        CoroutineScope(Dispatchers.Main).launch {
            while(isRunning) {
                delay(1000L)
                sessionTime++
            }
        }
    }

    // zastavit casonvac
    fun stopTimer() {
        isRunning = false
        sessionTime = 0
    }
}