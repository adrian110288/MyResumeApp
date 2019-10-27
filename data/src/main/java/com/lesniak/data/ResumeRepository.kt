package com.lesniak.data

import androidx.lifecycle.LiveData
import com.lesniak.data.models.Resume

interface ResumeRepository {

    val dataState: LiveData<Resume>

    suspend fun loadResume()
}