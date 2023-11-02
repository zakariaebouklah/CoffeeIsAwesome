package com.zakib.coffeeisgood

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class DataManager {

    // Every time the menu changes or every time the cart changes,we may need to update the UI, right?
    // Thus the need for the "by mutableStateOf(...)" clause.

    var menu : List<Category> by mutableStateOf(listOf())
    var cart : List<ItemInCart> by mutableStateOf(listOf())

    fun addToCart(p: Product): Unit {
        var found: Boolean = false

        cart.forEach {
            if(it.product.id == p.id){
                it.quantity++
                found = true
            }
        }

        /**
         * And if it wasn't found, I need to create,I need to add one item,
         * But I cannot add it because it's a list, not immutable list.
         * So what I need to do is create a copy.
         */

        if(!found){
            cart = listOf(*cart.toTypedArray(), ItemInCart(p, 1))
        }
    }

    fun removeFromCart(p: Product): Unit {
        val auxiliary = cart.toMutableList()
        auxiliary.removeAll { it.product.id == p.id }

        cart = listOf(*auxiliary.toTypedArray())
    }

    fun clearCart(): Unit{
        cart = listOf()
    }

}