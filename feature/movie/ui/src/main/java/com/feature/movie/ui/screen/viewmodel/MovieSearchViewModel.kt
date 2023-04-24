package com.feature.movie.ui.screen.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.feature.movie.domain.use_cases.GetMovieListUseCase
import com.feature.movie.ui.BuildConfig
import com.feature.movie.ui.screen.state.MovieSearchStateHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieSearchViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
) : ViewModel() {

    private val _movieList = mutableStateOf(MovieSearchStateHolder())
    val movieList: State<MovieSearchStateHolder> get() = _movieList

    private val _query: MutableStateFlow<String> = MutableStateFlow("")
    val query: StateFlow<String> get() = _query

    val API_KEY = BuildConfig.API_KEY

    init {
        viewModelScope.launch {
            _query.debounce(1000).collectLatest {
                getMovieList(apikey = API_KEY, q = it)
            }
        }
    }

    fun setQuery(s: String) {
        _query.value = s
    }

    fun getMovieList(apikey: String, q: String) = viewModelScope.launch {
        getMovieListUseCase(apikey, q).onEach {
            when (it) {
                is UiEvent.Error -> {
                    _movieList.value = MovieSearchStateHolder(error = it.message.toString())
                }
                is UiEvent.Loading -> {
                    _movieList.value = MovieSearchStateHolder(loading = true)
                }
                is UiEvent.Success -> {
                    _movieList.value = MovieSearchStateHolder(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}