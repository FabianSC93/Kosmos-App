package com.mexingsoft.kosmosapp.di

import com.mexingsoft.kosmosapp.data.repository.CharacterRepository
import com.mexingsoft.kosmosapp.domain.GetCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetCharactersUseCase(characterRepository: CharacterRepository) =
        GetCharactersUseCase(characterRepository)
}