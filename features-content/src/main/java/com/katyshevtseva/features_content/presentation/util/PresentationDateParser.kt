package com.katyshevtseva.features_content.presentation.util

import java.text.SimpleDateFormat
import java.util.Locale

object PresentationDateParser {
    private val responseFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
    private val readableFormat = SimpleDateFormat("d MMMM yyyy", Locale("ru"))

    private val reformatCache = mutableMapOf<String, String>()

    fun reformat(input: String): String {
        return reformatCache.getOrPut(input) {
            readableFormat.format(responseFormat.parse(input)!!)
        }
    }
}