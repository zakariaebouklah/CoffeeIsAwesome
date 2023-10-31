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
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    /**
     * Remember, it's just a call where we can ask the framework to remember that value.
     * Remember will actually act like it's similar to memo in other frameworks.
     *
     * PS: we can remember states as well as plain values
     */
    var name = remember {
        mutableStateOf("Zakariae")
        /**
         * like in React we create a state(s) for the composable
         * So I need to trigger a change within a state and we can do that but in this case we need to call mutableStateOf.
         * In this case we are setting that is going to be the state of these composable.
         * So that means that if the variable changes the state of the composable changes,
         * and it's going to trigger a re-render.
          */

    }
    Row { // a column is used like a container to hold different composables.
        Text("Hi My Name is ${name.value}")
        TextField(value = name.value, onValueChange = {
            name.value= it
        })
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