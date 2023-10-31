package com.zakib.coffeeisgood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zakib.coffeeisgood.ui.theme.CoffeeIsGoodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeeIsGoodTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Greeting("Android")
                    Text("Hiii !!!")
                }
            }
        }
    }
}

/**
 * creating custom composable
 * 'Text' is a built-in composable
 */
//@Preview
@Preview
@Composable
fun FirstComposable(): Unit {
    Row { // a column is used like a container to hold different composables.
        Text(
            text= "Hi I'm Zaki...",
            modifier = Modifier
                .background(Color.Green)
                .padding(16.dp)
        )
        Text(
            text= "Hi I'm a soft-dev engineer....",
            modifier = Modifier
                .background(Color.Gray)
                .padding(16.dp)
        )
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    CoffeeIsGoodTheme {
//        Greeting("Android")
//    }
//}