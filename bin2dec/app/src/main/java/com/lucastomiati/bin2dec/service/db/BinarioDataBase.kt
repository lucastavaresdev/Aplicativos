package com.lucastomiati.bin2dec.service.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lucastomiati.bin2dec.service.Model.Conversao

@Database(entities = [Conversao::class], version = 2, exportSchema = false)
abstract class BinarioDataBase : RoomDatabase() {

    abstract val binarioDao : BinarioDAO

    companion object{
        @Volatile
        private var INSTANCE : BinarioDataBase?  = null
        fun getInstance(context: Context): BinarioDataBase{
            synchronized(this){
                var instance = INSTANCE
                if (instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BinarioDataBase::class.java,
                        "Binario_data_Base"
                    ).build()
                }
                return instance
            }
        }
    }
}