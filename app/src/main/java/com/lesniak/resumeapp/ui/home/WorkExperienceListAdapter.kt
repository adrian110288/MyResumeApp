package com.lesniak.resumeapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lesniak.resumeapp.data.models.WorkExperience
import com.lesniak.resumeapp.databinding.ItemWorkExperienceBinding
import javax.inject.Inject

class WorkExperienceListAdapter @Inject constructor(diffUtil: WorkExperienceListDiffUtil) :
    ListAdapter<WorkExperience, WorkExperienceListAdapter.ViewHolder>(diffUtil) {

    class ViewHolder(val binding: ItemWorkExperienceBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemWorkExperienceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.experience = getItem(position)
    }
}