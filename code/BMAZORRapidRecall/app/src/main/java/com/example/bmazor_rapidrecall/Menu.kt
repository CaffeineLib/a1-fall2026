package com.example.bmazor_rapidrecall

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.then

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class Menu (private val modifier : Modifier = Modifier){

    //Hard Settings
    private val MAXTIME: Int = 99
    private val MAXDIGIT: Int = 20

    var digitlen = mutableStateOf("")
    var timelen = mutableStateOf("")


    @Composable
    private fun generic_TextField(
        lbl:String,
        myval: MutableState<String>,
        maxval: Int,
    ){
        TextField(
            modifier = modifier,
            value = myval.value,

            // Label box Digit Length
            label = {Text(lbl)},

            // Restrict to 1 line. Not necessary but i like it.
            maxLines = 1,

            // Make onscreen keyboard only allow numbers.
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

            // On changes
            onValueChange = {self ->
                if (self.isEmpty() || self.all {it.isDigit()}){
                    // only update if compliant else will hold regular.
                    if ((self.toIntOrNull() ?:0) > maxval){
                        myval.value = maxval.toString()
                    }else{
                        myval.value = self
                    }
                }
            },
        )
    }

    @Composable
    public fun show(onClick: () -> Unit){

        Column() {
            // Textbox for Digit Length
            generic_TextField(lbl = "Digits to memorize", myval = digitlen, maxval = MAXDIGIT)
            generic_TextField(lbl = "Time delay allowance", myval = timelen, maxval = MAXTIME)
            TextButton (
                modifier = modifier,
                onClick = {onClick ()},
            ) {
                Text("Begin")
            }
        }
    }

}