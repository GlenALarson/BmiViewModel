package com.example.bmiviewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

class BmiViewModel : ViewModel() {
    private val _heightInput = mutableStateOf("")
    val heightInput: State<String> = _heightInput

    private val _weightInput = mutableStateOf("")
    val weightInput: State<String> = _weightInput

    private val _bmi = mutableStateOf(0.0)
    val bmi: State<Double> = _bmi

    fun updateHeightInput(newHeight: String) {
        _heightInput.value = newHeight.replace(',', '.')
        calculateBmi()
    }

    fun updateWeightInput(newWeight: String) {
        _weightInput.value = newWeight.replace(',', '.')
        calculateBmi()
    }

    private fun calculateBmi() {
        val height = _heightInput.value.toFloatOrNull() ?: 0.0f
        val weight = _weightInput.value.toIntOrNull() ?: 0
        _bmi.value = if (weight > 0 && height > 0) (weight / (height * height)).toDouble() else 0.0
    }
}
