package com.plcoding.daggerhiltcourse.module1.di

import com.plcoding.daggerhiltcourse.module1.data.remote.MyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // how long it will live, in this case as long as the App itself
object AppModule {

    @Provides
    @Singleton // only one instance in life-time
    fun provideMyApi(): MyApi {
        return Retrofit.Builder()
            .baseUrl("https://test.com")
            .build()
            .create(MyApi::class.java)
    }

    /*@Provides
    @Singleton
    fun provideMyRepository(
        api: MyApi,
        application: Application, // This is how to provide context (not like @ApplicationContext anymore), but Application class needs to exist
        @Named("hello1") hello1: String // when multiple dependencies of same type
    ): MyRepository {
        // Here we can choose which repo to provide Real One or Fake One for testing
        return MyRepositoryImpl(api, application)
    }*/

    @Provides
    @Singleton
    @Named("hello1")
    fun provideString1() = "Hello 1"

    @Provides
    @Singleton
    @Named("hello2")
    fun provideString2() = "Hello 2"
}