package com.zakib.coffeeisgood

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.zakib.coffeeisgood.ui.theme.Alternative1
import com.zakib.coffeeisgood.ui.theme.Alternative2
import com.zakib.coffeeisgood.ui.theme.Primary

/*
@Preview(showBackground = true)
@Composable
private fun OfferForPreview() {
    Offer(title = "Coffee Offer", description = "Coffee is good")
}
*/


@Preview(showBackground = true)
@Composable
fun OffersPage() {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
    ) {
        Offer(title = "Early Coffe", description = "10% off. Offer valid from 6am to 9am.")
        Offer(title = "Welcome Gift", description = "25% off on your first order.")
    }
}


/*
@Preview(showBackground = true)
@Composable
fun OffersPage() {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
    ) {
        for (i in 0..5) {
            Offer(title = "Offer $i", description = "Description $i")
        }
    }
}
*/

@Composable
fun Offer(title: String, description: String) {

    /*
        val style = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp
        )
    */

    Box(modifier = Modifier.padding(16.dp)){

        /**
         * using the background_pattern svg
         */
        Image(
            painter = painterResource(R.drawable.background_pattern),
            contentDescription = "Coffee Pattern",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        )

        /**
         * So the idea is that we can go and use all the semantic styles in the theme
         * and try to keep working there instead of hard coding.
         */
        Column (
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Text(
                text = title,
                style = MaterialTheme.typography.h3,
                // using the theme colors
                modifier = Modifier
                    .padding(16.dp)
                    .background(Primary)
                    .padding(16.dp),
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.h5,
                // using the colors defined inside Colors.kt directly
                modifier = Modifier
                    .padding(16.dp)
                    .background(Alternative2)
                    .padding(16.dp)
                    .background(Alternative1)
            )

        }
    }
}