package com.lesniak.resumeapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lesniak.resumeapp.data.Result
import com.lesniak.resumeapp.data.ResumeRepository
import com.lesniak.resumeapp.data.models.Bio
import kotlinx.coroutines.launch

class HomeViewModel(private val resumeRepo: ResumeRepository) : ViewModel() {

    init {
        viewModelScope.launch {
            resumeRepo.loadBio()
        }
    }

    private val bioState: LiveData<Result<Bio>> = resumeRepo.bioState

    private val bio: LiveData<Bio?> = map(bioState) { (it as? com.lesniak.resumeapp.data.ResourceState.Result.Success)?.data }

    val isBioLoading: LiveData<Boolean> = map(bioState) { it is com.lesniak.resumeapp.data.ResourceState.Result.Loading }

    val fullName = map(bio) { it?.fullName }
    val occupation = map(bio) { it?.occupation }
    val location = map(bio) { it?.location }
    val summary = map(bio) { it?.summary }

}
