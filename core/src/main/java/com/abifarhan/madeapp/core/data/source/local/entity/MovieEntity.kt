package com.abifarhan.madeapp.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name="movieId")
    var movieId: String,

    @ColumnInfo(name="name")
    var movieName: String,

    @ColumnInfo(name="poster")
    var moviePoster: String,

    @ColumnInfo(name="overview")
    var movieOverview: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)
