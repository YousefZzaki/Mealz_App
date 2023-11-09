package com.example.domain.repo

import com.example.domain.entities.MealsResponse

interface MealsRepo {
   suspend fun getMealsListFromApi(): MealsResponse
}