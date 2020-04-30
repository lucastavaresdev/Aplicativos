package com.lucastomiati.bin2dec.model.Base

open class LogicHome {

    fun toDecimal(binario:String) : String{
        var potencia: Int = 0
        var decimal  = 0
        var a = binario.reversed()

        for (item in binario){
            decimal += Math.pow(2.0, potencia.toDouble()).toInt() * Character.getNumericValue(a.get(potencia))
            potencia++
        }
        return decimal.toString()
    }

}