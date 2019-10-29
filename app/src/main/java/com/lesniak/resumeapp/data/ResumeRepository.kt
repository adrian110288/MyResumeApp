package com.lesniak.resumeapp.data

import androidx.lifecycle.LiveData
import com.lesniak.resumeapp.data.models.Bio

interface ResumeRepository {

    val bioState: LiveData<ResourceState<Bio>>

    suspend fun loadBio()
}