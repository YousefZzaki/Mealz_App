package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.entities.MealsResponse
import com.example.domain.repo.MealsRepo

class MealsRepoImpl(private val api: ApiService) : MealsRepo{
    override suspend fun getMealsListFromApi(): MealsResponse = api.getMeals()
}