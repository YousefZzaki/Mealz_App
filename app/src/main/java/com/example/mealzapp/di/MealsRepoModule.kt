package com.example.mealzapp.di

import com.example.data.remote.ApiService
import com.example.data.repo.MealsRepoImpl
import com.example.domain.repo.MealsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MealsRepoModule {
    @Provides
    fun provMealsRepo(apiService: ApiService): MealsRepo {
        return MealsRepoImpl(apiService)
    }
}