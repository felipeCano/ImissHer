package com.example.imissher.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imissher.AnalyticsAdapter
import com.example.imissher.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
//var pruebaString = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         lateinit var analytics: AnalyticsAdapter
        //1,36,1,34
       /* val decimalNumbers = byteArrayOf(84, 50, 65,48,48,49,53,80)

        val hexArray = decimalNumbers.map { it.toString(16).toUpperCase() }.toTypedArray()

        for ((index, decimalNumber) in decimalNumbers.withIndex()) {
            if (hexArray[index].length == 1){
                hexArray[index] = hexArray[index].padStart(2,'0')
            }
            pruebaString += hexArray[index]
            println("Decimal $decimalNumber in hexadecimal: ${hexArray[index]}")
        }
            println(pruebaString.decodeHex2())*/
    }

    fun String.decodeHex2(): String {
        require(length % 2 == 0) {"Must have an even length"}
        return chunked(2)
            .map { it.toInt(16).toByte() }
            .toByteArray()
            .toString(Charsets.ISO_8859_1)  // Or whichever encoding your input uses
    }

}