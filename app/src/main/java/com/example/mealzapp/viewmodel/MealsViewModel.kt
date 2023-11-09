package com.example.mealzapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.MealsResponse
import com.example.domain.useCase.GetMeals
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(private val mealsUseCase: GetMeals) : ViewModel() {

    private val _mealsStateFlow: MutableStateFlow<MealsResponse?> = MutableStateFlow(null)
    val stateFlow: StateFlow<MealsResponse?> = _mealsStateFlow

    fun getMealsList() {
        viewModelScope.launch {
            try {
                _mealsStateFlow.value = mealsUseCase()
                Log.e("mTAG", mealsUseCase().toString())
                Log.e("mTAG", "state val: ${ _mealsStateFlow.value}")
            } catch (e: Throwable) {
                Log.e("Error", e.message.toString())
                e.printStackTrace()
            }
        }
    }
}