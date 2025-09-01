package com.katyshevtseva.features_content.presentation.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager

class CompositeCourseAdapter(
    context: Context,
    likeButtonListener: ((CourseItem) -> Unit)?
) : ListAdapter<CourseItem, RecyclerView.ViewHolder>(CourseItemDiffCallback()) {

    private val delegatesManager = AdapterDelegatesManager<List<ListItem>>()

    init {
        delegatesManager.addDelegate(CourseDelegate(context, likeButtonListener))
    }

    override fun getItemViewType(position: Int): Int =
        delegatesManager.getItemViewType(currentList, position)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        delegatesManager.onCreateViewHolder(parent, viewType)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegatesManager.onBindViewHolder(currentList, position, holder)
    }
}