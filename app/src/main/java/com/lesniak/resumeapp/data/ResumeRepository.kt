package com.lesniak.resumeapp.data

import androidx.lifecycle.LiveData
import com.lesniak.resumeapp.data.models.Bio

interface ResumeRepository {

    suspend fun loadBio(): LiveData<Result<Bio>>
}