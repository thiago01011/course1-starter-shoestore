package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class AppViewModel: ViewModel() {
    private val _loginMap = MutableLiveData<MutableMap<String, String>>()
    var loginMap: LiveData<MutableMap<String, String>> = _loginMap

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    var shoeList: LiveData<MutableList<Shoe>> = _shoeList

    private val _shoeItem = MutableLiveData<Shoe>()
    var shoeItem = MutableLiveData<Shoe>()

    init {
        _shoeList.value = mutableListOf<Shoe>()
        _loginMap.value = mutableMapOf<String, String>()

    }
}