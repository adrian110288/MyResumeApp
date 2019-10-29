package com.lesniak.resumeapp.data

import com.lesniak.resumeapp.data.models.Bio
import retrofit2.http.GET

interface ResumeService {

    @GET("137493acaf58061c34130aba9ea0235d/raw/5f028c05720459a40a70ca751ff56b99b77386ad/resume-bio.json")
    suspend fun getBio(): Bio
}