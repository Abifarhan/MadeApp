package com.abifarhan.madeapp.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val movieId: String,
    val name:String,
    val poster:String,
    val overview:String,
    val isFavorite:Boolean
): Parcelable