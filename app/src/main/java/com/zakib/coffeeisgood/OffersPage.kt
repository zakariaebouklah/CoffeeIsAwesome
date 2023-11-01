package com.zakib.coffeeisgood

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview
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
    Column {
        Text(text = "My title", style = MaterialTheme.typography.h1)
        Text(text = "Description", style = MaterialTheme.typography.h3)
    }
}