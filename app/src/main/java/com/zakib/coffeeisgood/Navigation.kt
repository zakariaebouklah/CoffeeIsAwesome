package com.zakib.coffeeisgood

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.zakib.coffeeisgood.ui.theme.Alternative1
import androidx.compose.material.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.zakib.coffeeisgood.ui.theme.Primary

data class Navigation(
    var name:String,
    var icon:ImageVector,
    var route:String,
){

}

object Routes {
    val MenuPage= Navigation(name = "Menu", Icons.Outlined.Menu, route = "menu")
    val OffersPage= Navigation(name = "Offers", Icons.Outlined.Star, route = "offers")
    val OrderPage= Navigation(name = "My Order", Icons.Outlined.ShoppingCart, route = "my-order")
    val InfoPage= Navigation(name = "Menu", Icons.Outlined.Info, route = "info")

    val Pages = listOf(MenuPage, OffersPage, OrderPage, InfoPage)
}

@Preview(showBackground = true)
@Composable
fun NavBarItemPreview() {
    NavBarItem(page = Routes.MenuPage, modifier = Modifier.padding(8.dp))
}

@Composable
fun NavBar(selectedRoute: String = Routes.MenuPage.route, callback: (String) -> Unit) {
    Row {
        for (page in Routes.Pages){
            NavBarItem(
                page = page,
                selected = page.route == selectedRoute,
                // apply a modifier to perform click
                modifier = Modifier.clickable {
                    callback(page.route)
                }
            )
        }
    }
}

/**
 * My own composable does not contain modifiers, If I want modifiers,
 * I need to accept that were in the function signature, is of type modifier.
 */
@Composable
fun NavBarItem(page: Navigation, selected: Boolean = false, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        /**
         * What it's doing it depends on the modifier.Okay, what's it gonna do?In this case,
         * it's not like making a padding of 20.
         * It first makes another with 12 and another with 8 more.
         */
        modifier = modifier.padding(horizontal = 12.dp)) {
        Image(
            imageVector = page.icon,
            contentDescription = page.name,
            colorFilter = ColorFilter.tint(
                if (selected) Alternative1 else Primary
            ),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(24.dp)
        )
        Text(page.name,
            fontSize = 12.sp,
            color = if (selected) Alternative1 else Primary
        )
    }
}