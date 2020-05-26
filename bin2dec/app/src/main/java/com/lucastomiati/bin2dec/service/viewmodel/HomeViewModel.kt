package com.lucastomiati.bin2dec.service.viewmodel

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.lucastomiati.bin2dec.service.Model.Conversao
import com.lucastomiati.bin2dec.service.db.BinarioRepository
import com.lucastomiati.bin2dec.utils.Converter
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class HomeViewModel(private val repository: BinarioRepository): ViewModel(), Observable {

    val conversoes = repository.conversoes
    @Bindable
    val inputBinario = MutableLiveData<String>()

    @Bindable
    var resultado = MutableLiveData<String>()

    init{
        resultado.value = ""
    }

    fun calcular(){
        if(inputBinario.value == null){
            Log.i("teste", "null")
        }else{
            val logicaDecimal = Converter()
            var numeroBinarioEntrada  = inputBinario.value
            var numeroConvertidoDecimal = logicaDecimal.toDecimal(numeroBinarioEntrada.toString())

            resultado.value = numeroConvertidoDecimal


            if (numeroBinarioEntrada != null) {
                insert(Conversao(0,numeroBinarioEntrada.toInt(),numeroConvertidoDecimal.toInt()))
            }

//            Log.i("teste", logicaDecimal.toDecimal(numeroBinarioEntrada.toString()))
//            Log.i("teste", inputBinario.value)
        }
    }

    fun insert(binario: Conversao): Job = viewModelScope.launch {
        repository.insert(binario)
    }


    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }


}






