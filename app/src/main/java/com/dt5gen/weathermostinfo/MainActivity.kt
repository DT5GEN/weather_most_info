package com.dt5gen.weathermostinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dt5gen.weathermostinfo.ui.theme.WeatherMostInfoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherMostInfoTheme {
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

@Composable
fun Greeting(city: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxHeight(0.5f)
            .fillMaxWidth()
            .background(Color.Green),
        contentAlignment = Alignment.Center){
            Text(text = "Current TEMP in  $city!")
        }

        Box(modifier = Modifier.fillMaxHeight()
            .fillMaxWidth()
            .background(Color.Blue),
            contentAlignment = Alignment.BottomCenter) {
            Button(onClick = { },
            modifier = Modifier.padding(8.dp).fillMaxWidth()) {
                Text(text = "Refresh")
            }


        }


    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherMostInfoTheme {
        Greeting("VasSSya")
    }
}