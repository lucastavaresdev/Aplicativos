package com.lucastomiati.bin2dec.service.db
import com.lucastomiati.bin2dec.service.Model.Conversao

class BinarioRepository (private val dao : BinarioDAO){

    val conversoes = dao.listarConversoes()

    suspend fun insert(binario: Conversao): Long{
        return dao.insertConversao(binario)
    }

    suspend fun  update(binario: Conversao):Int{
        return dao.updateConversao(binario)
    }

    suspend fun delete(binario: Conversao): Int{
        return dao.deleteConversao(binario)
    }

    suspend fun deleteAll() : Int{
        return dao.deleteAll()
    }

}