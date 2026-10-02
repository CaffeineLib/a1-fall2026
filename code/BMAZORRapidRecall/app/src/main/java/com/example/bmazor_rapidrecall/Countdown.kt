package com.example.bmazor_rapidrecall

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

class Countdown() {

    @Composable
    fun go(
        timer: Int,
        onFinish: () -> Unit,
        modifier: Modifier = Modifier
    ) {
        var timeRemaining by remember(timer) { mutableIntStateOf(timer) }

        val currentOnFinish by rememberUpdatedState(onFinish)

        //Stupid Co Routine, Android wants this as its safer than a os.sleep()
        LaunchedEffect(timer) {
            while (timeRemaining > 0) {
                delay(1000L)
                timeRemaining--
            }
            currentOnFinish()
        }

        Text(
            text= timeRemaining.toString(),
            fontSize = 120.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

