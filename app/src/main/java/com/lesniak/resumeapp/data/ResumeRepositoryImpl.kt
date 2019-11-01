package com.lesniak.resumeapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.lesniak.resumeapp.data.models.Bio
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResumeRepositoryImpl @Inject constructor(private val resumeService: ResumeService) :
    ResumeRepository {

    override suspend fun loadBio(): LiveData<Result<Bio>> = liveData {
        emit(Result.Loading)

        try {
            emit(Result.Success(resumeService.getBio()))
        } catch (e: Exception) {
            emit(Result.Failure(e))
        }

    }
}