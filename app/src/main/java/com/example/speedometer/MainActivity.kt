package com.example.speedometer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.FloatRange
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.speedometer.ui.theme.SpeedometerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpeedometerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
private fun Speedometer(
    @FloatRange(from = 0.0, to = 240.0) currentSpeed: Float,
    modifier: Modifier
) {
    val textMeasurer = rememberTextMeasurer()
    val textColor = MaterialTheme.colorScheme.onSurface
    val indicatorColor = MaterialTheme.colorScheme.onSurface

    Canvas(modifier = modifier, onDraw = {
        drawArc(color = Color.Red, startAngle = 30f, sweepAngle = -240f, useCenter = false, style = Stroke(width = 2.0.dp.toPx()))
    })
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SpeedometerTheme {
        Greeting("Android")
    }
}