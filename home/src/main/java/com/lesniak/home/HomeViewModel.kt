package com.lesniak.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lesniak.data.ResumeRepository
import com.lesniak.data.ResumeRepositoryImpl
import com.lesniak.data.models.Resume
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val resumeRepo: ResumeRepository

    init {
        resumeRepo = ResumeRepositoryImpl()

        viewModelScope.launch {
            resumeRepo.loadResume()
        }
    }

    val resumeState: LiveData<Resume> = resumeRepo.dataState


}
