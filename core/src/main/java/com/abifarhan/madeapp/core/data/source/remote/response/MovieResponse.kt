package com.abifarhan.madeapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @field:SerializedName("id")
    val id: String,

    @field: SerializedName("original_name")
    val name: String,

    @field: SerializedName("poster_path")
    val poster: String,

    @field: SerializedName("overview")
    val overview: String,
)