package com.lesniak.resumeapp.data

import androidx.lifecycle.LiveData
import com.lesniak.resumeapp.data.models.Bio
import com.lesniak.resumeapp.data.models.Skill

interface ResumeRepository {

    suspend fun loadBio(): LiveData<Result<Bio>>

    suspend fun loadSkills(): LiveData<Result<List<Skill>>>
}