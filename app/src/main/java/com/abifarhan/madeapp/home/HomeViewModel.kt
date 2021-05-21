package com.abifarhan.madeapp.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.abifarhan.madeapp.core.domain.usecase.MovieUseCase

class HomeViewModel(movieUseCase: MovieUseCase): ViewModel() {

    val movie =
        movieUseCase.getAllMovies().asLiveData()
}