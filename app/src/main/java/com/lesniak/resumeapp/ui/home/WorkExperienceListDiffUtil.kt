package com.lesniak.resumeapp.ui.home

import androidx.recyclerview.widget.DiffUtil
import com.lesniak.resumeapp.data.models.WorkExperience
import javax.inject.Inject

class WorkExperienceListDiffUtil @Inject constructor() : DiffUtil.ItemCallback<WorkExperience>() {
    override fun areItemsTheSame(oldItem: WorkExperience, newItem: WorkExperience): Boolean =
        oldItem === newItem

    override fun areContentsTheSame(oldItem: WorkExperience, newItem: WorkExperience): Boolean =
        oldItem.position == newItem.position &&
                oldItem.company == newItem.company &&
                oldItem.startDate == newItem.startDate &&
                oldItem.endDate == newItem.endDate &&
                oldItem.present == newItem.present
}