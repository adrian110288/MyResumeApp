package com.lesniak.resumeapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lesniak.resumeapp.data.ResumeRepository
import com.lesniak.resumeapp.data.models.Resume
import kotlinx.coroutines.launch

class HomeViewModel(private val resumeRepo: ResumeRepository) : ViewModel() {

    init {
        viewModelScope.launch {
            resumeRepo.loadResume()
        }
    }

    val resumeState: LiveData<Resume> = resumeRepo.dataState


}
