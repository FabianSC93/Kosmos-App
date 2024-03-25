package com.mexingsoft.kosmosapp.di

import android.content.Context
import com.mexingsoft.kosmosapp.data.network.CharacterService
import com.mexingsoft.kosmosapp.data.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCharacterRepository(
        characterService: CharacterService,
        @ApplicationContext context: Context
    ) = CharacterRepository(characterService, context)
}