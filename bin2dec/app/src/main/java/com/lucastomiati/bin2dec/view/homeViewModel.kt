package com.lucastomiati.bin2dec.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucastomiati.bin2dec.model.Base.LogicHome

class homeViewModel: ViewModel() {

    val decimalLiveData: MutableLiveData<String> = MutableLiveData()

    fun getDecimal(binario:String){

        var conversorDecimal = LogicHome()
        val resultDecimal = conversorDecimal.toDecimal(binario)
        decimalLiveData.value = resultDecimal
    }
}