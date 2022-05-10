package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class AppViewModel : ViewModel() {
    private val _shoe = MutableLiveData<Shoe>()
    var shoe: LiveData<Shoe> = _shoe

    private val _shoeListLiveData = MutableLiveData<List<Shoe>>()
    var shoeListLiveData: LiveData<List<Shoe>> = _shoeListLiveData

    // List that will be added to _shoeListLiveData as value
    private val shoeList = mutableListOf<Shoe>()

    init {
        _shoeListLiveData.value = shoeList
    }

    fun addShoe(shoe: Shoe?) {
        if (shoe != null) {
            shoeList.add(shoe)
        }
        _shoeListLiveData.value = shoeList
    }
}