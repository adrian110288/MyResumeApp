package com.lesniak.resumeapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lesniak.resumeapp.data.Result
import com.lesniak.resumeapp.data.ResumeRepository
import com.lesniak.resumeapp.data.models.Bio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val resumeRepo: ResumeRepository) : ViewModel() {

    lateinit var bioLiveData: LiveData<Result<Bio>>

    init {
        viewModelScope.launch(Dispatchers.IO) {
            bioLiveData = resumeRepo.loadBio()
        }
    }

    val isBioLoading = MutableLiveData<Boolean>()

    val bio = MutableLiveData<Bio>()
}
