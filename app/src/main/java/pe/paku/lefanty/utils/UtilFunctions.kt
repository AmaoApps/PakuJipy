package pe.paku.lefanty.utils

import kotlin.math.abs
import kotlin.math.log10

class UtilFunctions {

    fun getStringPassword(valor : String):String{
        val numberCharacter = valor.length
        return "*".repeat(numberCharacter)
    }

    fun getIntPassword(valor : Int):String{
        return "*".repeat(valor.length())
    }

    //Extension
    fun Int.length() = when(this) {
        0 -> 1
        else -> log10(abs(toDouble())).toInt() + 1
    }

}