package com.lucastomiati.bin2dec.service.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lucastomiati.bin2dec.service.Model.Conversao

@Dao
interface BinarioDAO {

    @Insert
    suspend fun insertConversao(binario: Conversao): Long

    @Update
    suspend fun updateConversao(binario: Conversao): Int

    @Delete
    suspend fun deleteConversao(binario: Conversao): Int

    @Query("DELETE FROM binarios_data_table")
    suspend fun deleteAll() : Int

    @Query("SELECT * FROM binarios_data_table")
    fun listarConversoes(): LiveData<List<Conversao>>

}