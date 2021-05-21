package com.abifarhan.madeapp.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.abifarhan.madeapp.core.domain.usecase.MovieUseCase

class FavoritViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val favoriteMovie = movieUseCase.getFavoriteMovies().asLiveData()
}