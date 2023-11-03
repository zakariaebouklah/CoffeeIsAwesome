package com.zakib.coffeeisgood.pages

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

@Preview
@Composable
fun InfoPage() {
    CustomWebView()
}

/**
 * use cases for WebView:
 * ---> load a full webpage (html/css/js)
 * ---> auth pages
 * ---> hybrid apps (hybrid = half web / half native)
 */

@Composable
fun CustomWebView() {
    // Declare a string that contains a url
    val url = "https://firtman.github.io/coffeemasters/webapp"

    // Adding a WebView inside AndroidView
    // with layout as full screen
    AndroidView(
        factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )

            webViewClient = WebViewClient() // customize the web-view
            loadUrl(url)
        }
    },
        update = {
            it.loadUrl(url)
        }
    )
}