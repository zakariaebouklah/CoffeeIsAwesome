package com.zakib.coffeeisgood.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.zakib.coffeeisgood.Product
import androidx.compose.material.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.material.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.zakib.coffeeisgood.ui.theme.Alternative1
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import coil.compose.AsyncImage
import com.zakib.coffeeisgood.DataManager
import com.zakib.coffeeisgood.ui.theme.CardBackground

@Composable
fun MenuPage(dataManager: DataManager) {
    LazyColumn{

        items(dataManager.menu){
            Text(it.name)
            it.products.forEach{ p ->
                Card (
                    elevation = 2.dp,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .background(CardBackground)
                        .padding(12.dp)
                ){
                    ProductItem(product = p, onAdd = {dataManager.addToCart(p)})
                }
            }
        }
    }
}

// Extension function to format the double
fun Double.format(digits: Int) = "%.${digits}f".format(this)

@Composable
fun ProductItem(product: Product, onAdd: (Product)->Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {

        AsyncImage(
            model = product.imageUrl,
            contentDescription = "Image for ${product.name}",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text(product.name, fontWeight = FontWeight.Bold)
                Text("$${product.price.format(2)} ea")
            }
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Alternative1,
                    contentColor = Color.White
                ),
                onClick = {
                    onAdd(product)
                },
            ) {
                Text("Add")
            }
        }
    }
}