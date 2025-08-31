package com.katyshevtseva.features_content.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.katyshevtseva.features_content.R
import com.katyshevtseva.features_content.databinding.CourseItemBinding
import com.katyshevtseva.features_content.domain.model.Course

class CourseAdapter(
    val context: Context
) : ListAdapter<Course, CourseViewHolder>(CourseItemDiffCallback()) {

    var likeButtonListener: ((Course) -> Unit)? = null

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

        val likeButtonResource = if (course.favourite) {
            R.drawable.bookmark_filled
        } else {
            R.drawable.bookmark_empty
        }

        with(holder.binding) {
            titleTv.text = course.title
            textTv.text = course.text
            rateTv.text = course.rate
            startDateTv.text = context.getString(R.string.start_date, course.startDate)
            priceTv.text = course.price
            publishDateTv.text = context.getString(R.string.publish_date, course.publishDate)
            likeButton.setBackgroundResource(likeButtonResource)
            likeButton.setOnClickListener { likeButtonListener?.invoke(course) }
        }
    }
}

class CourseViewHolder(val binding: CourseItemBinding) : RecyclerView.ViewHolder(binding.root)