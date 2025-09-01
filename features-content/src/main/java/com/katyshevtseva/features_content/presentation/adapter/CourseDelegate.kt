package com.katyshevtseva.features_content.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.katyshevtseva.features_content.R
import com.katyshevtseva.features_content.databinding.CourseItemBinding
import com.katyshevtseva.features_content.presentation.util.PresentationDateParser

class CourseDelegate(
    private val context: Context,
    val likeButtonListener: ((CourseItem) -> Unit)?
) : AdapterDelegate<List<ListItem>>() {

    override fun isForViewType(items: List<ListItem>, position: Int): Boolean =
        items[position] is CourseItem

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        CourseViewHolder(
            context,
            CourseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            likeButtonListener
        )

    override fun onBindViewHolder(
        items: List<ListItem>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        (holder as CourseViewHolder).bind(items[position] as CourseItem)
    }

    class CourseViewHolder(
        val context: Context,
        val binding: CourseItemBinding,
        val likeButtonListener: ((CourseItem) -> Unit)?
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(course: CourseItem) {

            val likeButtonResource = if (course.favourite) {
                R.drawable.bookmark_filled
            } else {
                R.drawable.bookmark_empty
            }

            with(binding) {
                titleTv.text = course.title
                textTv.text = course.text
                rateTv.text = course.rate
                startDateTv.text =
                    context.getString(
                        R.string.start_date,
                        PresentationDateParser.reformat(course.startDate)
                    )
                priceTv.text = course.price
                publishDateTv.text =
                    context.getString(
                        R.string.publish_date,
                        PresentationDateParser.reformat(course.publishDate)
                    )
                likeButton.setBackgroundResource(likeButtonResource)
                likeButton.setOnClickListener { likeButtonListener?.invoke(course) }
            }

        }
    }
}