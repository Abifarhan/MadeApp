package com.abifarhan.madeapp.detail

import androidx.lifecycle.ViewModel
import com.abifarhan.madeapp.core.domain.model.Movie
import com.abifarhan.madeapp.core.domain.usecase.MovieUseCase

class DetailMovieViewModel(private val movieUseCase:
MovieUseCase) : ViewModel() {

    fun setFavoriteTourism(movie: Movie, newStatus:Boolean) =
        movieUseCase.setFavoriteMovies(movie, newStatus)
}