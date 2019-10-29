package com.lesniak.resumeapp.data.models

import com.google.gson.annotations.SerializedName

data class Bio(
    @SerializedName("full_name") val fullName: String,
    val occupation: String,
    val summary: String,
    val location: Location
)