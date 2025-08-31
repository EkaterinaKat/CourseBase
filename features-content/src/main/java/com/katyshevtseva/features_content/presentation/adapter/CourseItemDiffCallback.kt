package com.katyshevtseva.features_content.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.katyshevtseva.features_content.domain.model.Course

class CourseItemDiffCallback : DiffUtil.ItemCallback<Course>() {

    override fun areItemsTheSame(
        oldItem: Course,
        newItem: Course
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Course,
        newItem: Course
    ): Boolean {
        return oldItem.id == newItem.id && oldItem.favourite == newItem.favourite
    }
}