package com.example.bmazor_rapidrecall

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class RandomInt {

    var mynumber by mutableStateOf("")

    fun makeRandom(digits: Int){
        mynumber = ""
        if (digits >0 ){
            for ( i in 0 until digits){
                mynumber += (if(i ==0) (1..9) else(0..9)).random().toString()
            }
        }
    }



@Composable
fun show(digit:Int){
    var mynumber = mutalbe
}