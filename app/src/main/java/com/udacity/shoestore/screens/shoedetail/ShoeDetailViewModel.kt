package com.udacity.shoestore.screens.shoedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeDetailViewModel : ViewModel() {
    private val _shoe = MutableLiveData<Shoe>()
    var shoe: LiveData<Shoe> = _shoe

    init {
        _shoe.value = Shoe()
    }
}