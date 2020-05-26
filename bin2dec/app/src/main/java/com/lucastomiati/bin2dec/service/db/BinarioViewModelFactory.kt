package com.lucastomiati.bin2dec.service.db

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lucastomiati.bin2dec.service.viewmodel.HomeViewModel

class BinarioViewModelFactory (private val repository: BinarioRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(repository) as T
        }
        throw IllegalAccessException("Não encontrada View model class")
    }

}