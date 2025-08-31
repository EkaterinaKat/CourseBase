package com.katyshevtseva.features_content.domain.model

data class Course(
    val id: Int,
    val title: String,
    val favourite: Boolean,
    val text: String,
    val price: String,
    val rate: String,
    val startDate: String,
    val publishDate: String
)