package com.example.mealzapp.di

import com.example.domain.repo.MealsRepo
import com.example.domain.useCase.GetMeals
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provUseCase(repo: MealsRepo): GetMeals{
        return GetMeals(repo)
    }
}