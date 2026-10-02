package com.example.bmazor_rapidrecall

import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bmazor_rapidrecall.ui.theme.BMAZORRapidRecallTheme
import androidx.compose.ui.Alignment
import kotlin.concurrent.timer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            BMAZORRapidRecallTheme {
                var phase by remember  { mutableIntStateOf(1)}
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val mymenu = remember {Menu(modifier = Modifier
                        .fillMaxWidth()
                        .padding(innerPadding)
                    )}
                    val mytimer = remember{Countdown()}



                        Box(modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                            contentAlignment = Alignment.Center
                        ){
                            if (phase ==1){
                                mymenu.show(onClick = {phase =2})
                            } else if (phase == 2){
                                mytimer.go(timer=mymenu.timelen.value.toInt(), onFinish = {phase =1})
                            }
                        }
                    }

                }
            }
        }

}






