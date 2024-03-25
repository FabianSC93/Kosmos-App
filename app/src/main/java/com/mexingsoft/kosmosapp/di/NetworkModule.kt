package com.mexingsoft.kosmosapp.di

import com.mexingsoft.kosmosapp.data.network.CharactersClient
import com.mexingsoft.kosmosapp.utils.Constants.BASE_URL_RICKY_AND_MORTY
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL_RICKY_AND_MORTY)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideCharactersClient(retrofit: Retrofit) = retrofit.create(CharactersClient::class.java)
}