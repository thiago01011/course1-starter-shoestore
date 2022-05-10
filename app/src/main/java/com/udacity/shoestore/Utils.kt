package com.udacity.shoestore

import androidx.databinding.InverseMethod

object Utils {
    @InverseMethod("convertStringToDouble")
    @JvmStatic
    fun convertDoubleToString(value: Double) = value.toString()

    @JvmStatic
    fun convertStringToDouble(value: String) = value.toDoubleOrNull() ?: 0.0

}