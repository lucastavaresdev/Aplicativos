package com.lucastomiati.exempleroom

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class WordViewModel(application: Application): AndroidViewModel(application) {

    private val wordrepository: WordRepository
    val allWords: LiveData<List<Word>>



}