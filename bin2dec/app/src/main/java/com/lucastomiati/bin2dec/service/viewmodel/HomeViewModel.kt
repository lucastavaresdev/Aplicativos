package com.lucastomiati.bin2dec.view

import android.app.Application
import androidx.lifecycle.*
import com.lucastomiati.bin2dec.Utils.Converter


import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class homeViewModel(application: Application): AndroidViewModel(application){

    val decimalLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun decimal2(binario: String): String? {
        val logicaDecimal = Converter()
        var resultado = logicaDecimal.toDecimal(binario)
        return resultado
    }


//    fun save(id: Int, binario: Int, decimal: Int) {
//        val guest = BinarioModel().apply {
//            this.id = id
//            this.binario = binario
//            this.decimal = decimal
//        }
//    }




}