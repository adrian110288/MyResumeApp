package com.lesniak.resumeapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lesniak.resumeapp.data.models.Skill
import com.lesniak.resumeapp.databinding.ItemSkillBinding
import javax.inject.Inject

class SkillListAdapter @Inject constructor(private val diffUtil: SkillListDiffUtil) :
    ListAdapter<Skill, SkillListAdapter.ViewHolder>(diffUtil) {

    class ViewHolder(val binding: ItemSkillBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemSkillBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.skill = getItem(position)
    }
}