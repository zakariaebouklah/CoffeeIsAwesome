package com.zakib.coffeeisgood

import androidx.compose.foundation.Image
import androidx.compose.material.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.zakib.coffeeisgood.pages.InfoPage
import com.zakib.coffeeisgood.pages.MenuPage
import com.zakib.coffeeisgood.pages.OrderPage
import com.zakib.coffeeisgood.ui.theme.CoffeeIsGoodTheme

@Preview
@Composable
fun AppPreview() {
    // using the desired custom theme not the default android theme.
    CoffeeIsGoodTheme {
        App()
    }
}

@Composable
fun App() {
    // setup the state for the navigation between pages
    val selectedRoute = remember {
        mutableStateOf("menu")
    }

    Scaffold (
        topBar = {
            TopAppBar() {
                AppTitle()
            }
        },
        content = {
                  when(selectedRoute.value){
                    Routes.MenuPage.route -> MenuPage()
                    Routes.InfoPage.route -> InfoPage()
                    Routes.OrderPage.route -> OrderPage()
                    Routes.OffersPage.route -> OffersPage()
                  }
        },
        bottomBar = {
            /**
             * This is called state hosting.
             * A state hosting is when you have a composable that receives one variable and sends also the value change through a lambda expression.
             */
            NavBar(
                selectedRoute = selectedRoute.value,
                onChange = { newRoute -> selectedRoute.value = newRoute })
        }
    )
}

@Composable
fun AppTitle() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo")
    }
}