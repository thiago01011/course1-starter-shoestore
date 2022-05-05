package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class AppViewModel : ViewModel() {
    private val _loginMap = MutableLiveData<MutableMap<String, String>>()
    var loginMap: LiveData<MutableMap<String, String>> = _loginMap

    // List that will be added to _shoeListLiveData as value
    private val shoeList = mutableListOf<Shoe>()

    private val _shoeListLiveData = MutableLiveData<List<Shoe>>()
    var shoeListLiveData: LiveData<List<Shoe>> = _shoeListLiveData

    init {
        _shoeListLiveData.value = shoeList
        _loginMap.value = mutableMapOf<String, String>()
    }

    fun addShoe(shoe: Shoe?) {
        if (shoe != null) {
            shoeList.add(shoe)
        }
        _shoeListLiveData.value = shoeList
    }
}