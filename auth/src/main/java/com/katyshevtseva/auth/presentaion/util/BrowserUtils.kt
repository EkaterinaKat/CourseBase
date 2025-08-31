package com.katyshevtseva.auth.presentaion.util

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri

const val VK_URL = "https://vk.com/"
const val OK_URL = "https://ok.ru/"

fun browseUrl(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data = url.toUri()
    context.startActivity(intent)
}

