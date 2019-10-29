package com.lesniak.resumeapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lesniak.resumeapp.data.models.Bio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResumeRepositoryImpl @Inject constructor(private val resumeService: ResumeService) :
    ResumeRepository {

    private val _bioState: MutableLiveData<ResourceState<Bio>> = MutableLiveData()
    override val bioState: LiveData<ResourceState<Bio>> = _bioState

    override suspend fun loadBio() {

        _bioState.value = ResourceState.Loading()

        withContext(Dispatchers.IO) {
            val bio = resumeService.getBio()
            withContext(Dispatchers.Main) {
                _bioState.value = ResourceState.Success(bio)
            }
        }

    }
}