package com.feature.movie_details.ui.screens.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.feature.movie_details.domain.use_cases.GetMovieDetailUseCase
import com.feature.movie_details.ui.BuildConfig
import com.feature.movie_details.ui.screens.state.MovieDetailsStateHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _movieDetails = mutableStateOf(MovieDetailsStateHolder())
    val movieDetails: State<MovieDetailsStateHolder> get() = _movieDetails

    val API_KEY = BuildConfig.API_KEY

    init {
        savedStateHandle.getLiveData<String>("id").observeForever {
            it?.let {
                getMovieDetails(it, API_KEY)
            }
        }
    }

    fun getMovieDetails(id:String, apiKey:String) {
        getMovieDetailUseCase(id, apiKey).onEach {
            when(it) {
                is UiEvent.Error -> {
                    _movieDetails.value = MovieDetailsStateHolder(error = it.message.toString())
                }
                is UiEvent.Loading -> {
                    _movieDetails.value = MovieDetailsStateHolder(loading = true)
                }
                is UiEvent.Success -> {
                    _movieDetails.value = MovieDetailsStateHolder(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}