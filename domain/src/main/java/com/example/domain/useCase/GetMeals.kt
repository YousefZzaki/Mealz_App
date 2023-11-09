package com.example.domain.useCase

import com.example.domain.repo.MealsRepo

class GetMeals(private val mealsRepo: MealsRepo) {
    suspend operator fun invoke() = mealsRepo.getMealsListFromApi()
}