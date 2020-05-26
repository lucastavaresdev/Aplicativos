package com.lucastomiati.exempleroom

import android.provider.SyncStateContract.Helpers.insert
import androidx.lifecycle.LiveData

class WordRepository(private val wordDao: WordDao) {
    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizedWords()

     fun insert(word: Word){
        wordDao.insert(word)
    }

}