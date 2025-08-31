package com.katyshevtseva.auth.presentaion.util

import android.text.InputFilter

val inputFilter = InputFilter { source, start, end, dest, dstart, dend ->
    val pattern = Regex("[a-zA-Z0-9.@_]*")
    if (source.toString().matches(pattern)) {
        null
    } else {
        ""
    }
}