package com.plcoding.daggerhiltcourse.module2

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SessionViewModel @Inject constructor(
    private val sessionTimer: SessionTimer
): ViewModel() {


}