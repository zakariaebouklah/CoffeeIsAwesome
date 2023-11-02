package com.zakib.coffeeisgood.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.zakib.coffeeisgood.Product
import androidx.compose.material.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.material.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.zakib.coffeeisgood.ui.theme.Alternative1
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import com.zakib.coffeeisgood.DataManager
import com.zakib.coffeeisgood.R
import com.zakib.coffeeisgood.ui.theme.CardBackground

@Composable
fun MenuPage(dataManager: DataManager) {
    LazyColumn{
        items(count = 7){
            Card (
                elevation = 2.dp,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.background(CardBackground).padding(12.dp)
            ){
                ProductItem(product = Product(1, "Foo", 35.6, ""), onAdd = {})
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

        Image(
            painter = painterResource(id = R.drawable.black_coffee),
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