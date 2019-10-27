package com.lesniak.resumeapp.data

import com.lesniak.resumeapp.data.models.Resume
import retrofit2.http.GET

interface ResumeService {

    @GET("bd2850e4b0335b73613af4779499b576/raw/3a20ad742d2db6b49f1730384b3eba1ed2c7daaf/resumeapp-profile.json")
    suspend fun getResume(): Resume
}