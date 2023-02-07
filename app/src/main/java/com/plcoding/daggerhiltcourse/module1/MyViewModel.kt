package com.plcoding.daggerhiltcourse.module1

import android.app.Application
import androidx.lifecycle.ViewModel
import com.plcoding.daggerhiltcourse.R
import com.plcoding.daggerhiltcourse.module1.domain.repository.MyRepository
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// Lazy injection - Injecting a dependency and delaying the creation of the object

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: Lazy<MyRepository>, // Surround the object with Lazy from Dagger
    // MyRepository needs the api and context
    // Normally dependency is constructed as soon as we inject it
    // With Lazy it is created when we first use it
    private val appContext: Application

): ViewModel() {

    init {
        // when we use the dependency then it will be created
        repository.get()
        println(appContext.resources.getString(R.string.app_name))
    }

}