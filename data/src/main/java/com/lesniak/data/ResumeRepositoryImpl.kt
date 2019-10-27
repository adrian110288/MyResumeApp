package com.lesniak.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lesniak.data.models.Location
import com.lesniak.data.models.Resume

class ResumeRepositoryImpl : ResumeRepository {

    private val _dataState: MutableLiveData<Resume> = MutableLiveData()

    override val dataState: LiveData<Resume> = _dataState

    override suspend fun loadResume() {

        _dataState.value = Resume(
            "Name",
            "Job title",
            "Bio",
            Location("London", "UK"),
            listOf("Skill 1"),
            emptyList()
        )
    }
}