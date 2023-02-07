package com.plcoding.daggerhiltcourse.module2.di

import com.plcoding.daggerhiltcourse.module2.SessionTimer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    @ViewModelScoped
    fun provideSessionTimer(): SessionTimer {
        return SessionTimer()
    }
}