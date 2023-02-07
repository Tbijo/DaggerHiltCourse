package com.plcoding.daggerhiltcourse.module1.di

import com.plcoding.daggerhiltcourse.module1.data.repository.MyRepositoryImpl
import com.plcoding.daggerhiltcourse.module1.domain.repository.MyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    // In app module we are providing MyRepository
    // We want to inject the interface MyRepository
    // But we return a specific implementation

    // This is a easier way of achieving this
        // An easier way to provide interface or abstract class (providing an Abstraction)

    @Binds
    @Singleton
    abstract fun bindMyRepository(
        myRepositoryImpl: MyRepositoryImpl // Which implementation type we want to Inject
    ): MyRepository // The abstraction we want to provide in this case a Interface

    // Less code to write
    // Hilt will generate less code for Injecting such Interfaces or Abstract Classes than a @Provides function
    // Since there is no @Provides the Implementation (MyRepositoryImpl) needs to have @Inject constructor.
}