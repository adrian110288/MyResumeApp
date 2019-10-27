package com.lesniak.resumeapp.data

import androidx.lifecycle.LiveData
import com.lesniak.resumeapp.data.models.Resume

interface ResumeRepository {

    val dataState: LiveData<Resume>

    suspend fun loadResume()
}