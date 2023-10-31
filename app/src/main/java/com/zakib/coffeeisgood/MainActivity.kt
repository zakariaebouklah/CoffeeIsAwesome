package com.zakib.coffeeisgood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
    Text(
        text= "Hi I'm Zaki...",
        // order matters
//        modifier = Modifier.padding(16.dp).background(Color.Green)
        modifier = Modifier.background(Color.Green).padding(16.dp)
    )
}

@Preview(showBackground = true)
@Preview(widthDp = 150)
@Composable
fun SecondComposable(): Unit {
    Text(text= "Hi I'm Zaki...")
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