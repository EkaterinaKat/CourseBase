package com.katyshevtseva.features_content.presentation.adapter

import androidx.recyclerview.widget.DiffUtil

class CourseItemDiffCallback : DiffUtil.ItemCallback<CourseItem>() {

    override fun areItemsTheSame(
        oldItem: CourseItem,
        newItem: CourseItem
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: CourseItem,
        newItem: CourseItem
    ): Boolean {
        return oldItem.id == newItem.id && oldItem.favourite == newItem.favourite
    }
}