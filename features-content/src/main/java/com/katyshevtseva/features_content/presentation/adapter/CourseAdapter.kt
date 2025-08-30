package com.katyshevtseva.features_content.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.katyshevtseva.features_content.databinding.CourseItemBinding
import com.katyshevtseva.features_content.domain.model.Course

class CourseAdapter : ListAdapter<Course, CourseViewHolder>(CourseItemDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CourseViewHolder {
        return CourseViewHolder(
            CourseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: CourseViewHolder,
        position: Int
    ) {
        val course = getItem(position)

        with(holder.binding) {
            titleTv.text = course.title
            textTv.text = course.text
            rateTv.text = course.rate
            startDateTv.text = course.startDate
            priceTv.text = course.price
        }

    }
}

class CourseViewHolder(val binding: CourseItemBinding) : RecyclerView.ViewHolder(binding.root)