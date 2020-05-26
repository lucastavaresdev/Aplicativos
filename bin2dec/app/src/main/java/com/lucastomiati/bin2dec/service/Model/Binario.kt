package com.lucastomiati.bin2dec.service.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "binarios_data_table")
data class Conversao (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "con_id")
    var id : Int,
    @ColumnInfo(name = "con_binario")
    var binario : Int,
    @ColumnInfo(name = "con_decimal")
    var decimal : Int
)
