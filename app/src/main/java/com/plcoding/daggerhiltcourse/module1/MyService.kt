package com.plcoding.daggerhiltcourse.module1

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.plcoding.daggerhiltcourse.module1.domain.repository.MyRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

// Dependency Injection into a Service that runs in the background

@AndroidEntryPoint //nee to be annotated because service is a Android Component class
class MyService: Service() {

    // Normally we would add @Inject constructor but Services can not have constructors

    // Therefore we use field injection
    // Must be public can not be private
    @Inject
    lateinit var repository: MyRepository

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onCreate() {
        super.onCreate()
        // Injection happens after onCreate()
        // Here we can use the repository without the need to initialize it before
        //  repository.doNetworkCall()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}