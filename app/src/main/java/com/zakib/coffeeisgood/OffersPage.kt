package com.zakib.coffeeisgood

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zakib.coffeeisgood.ui.theme.Alternative1
import com.zakib.coffeeisgood.ui.theme.Alternative2

@Preview(showBackground = true)
@Composable
fun Offer() {

    val style = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    )

    /**
     * So the idea is that we can go and use all the semantic styles in the theme
     * and try to keep working there instead of hard coding.
     */
    Column (
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
            ){
        Text(
            text = "My title",
            style = MaterialTheme.typography.h1,
            // using the theme colors
            modifier = Modifier.background(MaterialTheme.colors.primary).padding(16.dp),
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Description",
            style = MaterialTheme.typography.h3,
            // using the colors defined inside Colors.kt directly
            modifier = Modifier
                .background(Alternative2)
                .padding(16.dp)
                .background(Alternative1)
        )
    }
}