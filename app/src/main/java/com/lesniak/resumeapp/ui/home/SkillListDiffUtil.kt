package com.lesniak.resumeapp.ui.home

import androidx.recyclerview.widget.DiffUtil
import com.lesniak.resumeapp.data.models.Skill
import javax.inject.Inject

class SkillListDiffUtil @Inject constructor() : DiffUtil.ItemCallback<Skill>() {
    override fun areItemsTheSame(oldItem: Skill, newItem: Skill): Boolean =
        oldItem === newItem

    override fun areContentsTheSame(oldItem: Skill, newItem: Skill): Boolean =
        oldItem.name == newItem.name &&
                oldItem.iconUrl == newItem.iconUrl
}