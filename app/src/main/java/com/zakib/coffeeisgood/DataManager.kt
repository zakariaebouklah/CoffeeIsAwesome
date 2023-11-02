package com.zakib.coffeeisgood

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

// converting data manager to a view model
class DataManager(app: Application) : AndroidViewModel(app) {

    // Every time the menu changes or every time the cart changes,we may need to update the UI, right?
    // Thus the need for the "by mutableStateOf(...)" clause.

    var menu : List<Category> by mutableStateOf(listOf())
    var cart : List<ItemInCart> by mutableStateOf(listOf())

    init {
        fetchData()
    }

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

    fun fetchData() {
        /**
         * Actually, what you put inside this code block is in a coroutine.
         * This is no 100% right, but let's say it's in a new thread.
         */
        viewModelScope.launch {
            menu = API.menuService.fetchMenu()
        }
    }

}