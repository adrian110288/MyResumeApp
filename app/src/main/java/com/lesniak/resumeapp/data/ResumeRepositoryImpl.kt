package com.lesniak.resumeapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lesniak.resumeapp.data.models.Location
import com.lesniak.resumeapp.data.models.Resume
import javax.inject.Inject

class ResumeRepositoryImpl @Inject constructor(private val resumeService: ResumeService) :
    ResumeRepository {

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