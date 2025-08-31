package com.katyshevtseva.features_content.data.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateParser {
    private val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
    private val cache = mutableMapOf<String, Date>()

    fun parse(string: String): Date {
        return cache.getOrPut(string) {
            formatter.parse(string)!!
        }
    }
}