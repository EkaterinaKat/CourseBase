package com.katyshevtseva.features_content.presentation.adapter

sealed class ListItem

data class CourseItem(
    val id: Int,
    val title: String,
    val favourite: Boolean,
    val text: String,
    val price: String,
    val rate: String,
    val startDate: String,
    val publishDate: String
) : ListItem()