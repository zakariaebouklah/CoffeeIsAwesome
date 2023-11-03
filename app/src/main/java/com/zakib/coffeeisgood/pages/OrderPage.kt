package com.zakib.coffeeisgood.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import com.zakib.coffeeisgood.DataManager
import com.zakib.coffeeisgood.ItemInCart
import com.zakib.coffeeisgood.Product
import com.zakib.coffeeisgood.ui.theme.Primary

@Composable
fun OrderPage(dataManager: DataManager) {
    LazyColumn{
        if(dataManager.cart.count() == 0){
            item {
                Card (
                    elevation = 4.dp,
                    modifier = Modifier.padding(16.dp)
                        ){
                    Text("Your Order is empty...", style = MaterialTheme.typography.h3)
                }
            }
        }
        items(dataManager.cart){
            CartItem(it = it, onDelete = {dataManager.removeFromCart(it)})
        }
    }
}

@Composable
fun CartItem(it: ItemInCart, onDelete: (Product)->Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()

    ) {
        Text("${it.quantity}x")
        Text(it.product.name,
            modifier = Modifier.width(150.dp)
        )
        Text("$${(it.quantity*it.product.price).format(2)}",
            modifier = Modifier.width(50.dp)
        )
        Image(
            imageVector = Icons.Filled.Delete,
            contentDescription = "Delete",
            colorFilter = ColorFilter.tint(Primary),
            modifier = Modifier.clickable {
                onDelete(it.product)
            }
        )
    }
}