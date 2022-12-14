package com.dt5gen.weathermostinfo

import android.content.Context
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.dt5gen.weathermostinfo.ui.theme.WeatherMostInfoTheme
import org.json.JSONObject

const val API_KEY = "9c4dca2eee744d2f9ba134332220209"

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
                    Greeting("Tokyo", this)
                }
            }
        }
    }
}

@Composable
fun Greeting(city: String, context: Context) {
    val state = remember {
        mutableStateOf("unknow")
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth()
            .background(Color.Green),
        contentAlignment = Alignment.Center){
            Text(text = "Current TEMP in  $city ${state.value} °C")
        }

        Box(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.Blue),
            contentAlignment = Alignment.BottomCenter) {
            Button(onClick = {
                             getWeatherInfo(city, state, context)
            },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()) {
                Text(text = "update")
            }


        }


    }

}

private fun getWeatherInfo(city: String, state: MutableState<String>, context: Context){
val url = "https://api.weatherapi.com/v1/current.json" + "?key=$API_KEY&" + "q=$city" + "&aqi=no"

    val queue = Volley.newRequestQueue(context)
    val stringRequest = StringRequest(
        Request.Method.GET,
        url, {
            response ->
            val obj = JSONObject(response)
            state.value = obj.getJSONObject("current").getString("temp_c")
        }, {
            error ->
        }
    )

    queue.add(stringRequest)

}