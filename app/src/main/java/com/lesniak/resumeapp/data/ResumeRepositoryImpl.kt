package com.lesniak.resumeapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.lesniak.resumeapp.data.models.Bio
import com.lesniak.resumeapp.data.models.Skill
import com.lesniak.resumeapp.data.models.WorkExperience
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResumeRepositoryImpl @Inject constructor(private val gitHubGistResumeService: GitHubGistResumeService) :
    ResumeRepository {

    override suspend fun loadBio(): LiveData<Result<Bio>> = liveData {
        emit(Result.Loading)

        try {
            emit(Result.Success(gitHubGistResumeService.getBio()))
        } catch (e: Exception) {
            emit(Result.Failure(e))
        }

    }

    override suspend fun loadSkills(): LiveData<Result<List<Skill>>> = liveData {
        emit(Result.Loading)

        try {
            emit(Result.Success(gitHubGistResumeService.getSkills()))
        } catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }

    override suspend fun loadWorkExperience(): LiveData<Result<List<WorkExperience>>> = liveData {
        emit(Result.Loading)

        try {
            emit(Result.Success(gitHubGistResumeService.getWorkExperience()))
        } catch (e: Exception) {
            emit(Result.Failure(e))
        }
    }
}