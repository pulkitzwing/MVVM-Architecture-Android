package me.pulkit.mvvm.ui.topheadline

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import me.pulkit.mvvm.data.model.Article
import me.pulkit.mvvm.data.repository.TopHeadlineRepository
import me.pulkit.mvvm.ui.base.UiState
import me.pulkit.mvvm.utils.AppConstant.COUNTRY

class TopHeadlineViewModel(private val topHeadlineRepository: TopHeadlineRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<Article>>>(UiState.Loading)

    val uiState: StateFlow<UiState<List<Article>>> = _uiState

    init {
        fetchTopHeadlines()
    }

    private fun fetchTopHeadlines() {
        viewModelScope.launch {
            topHeadlineRepository.getTopHeadlines(COUNTRY)
                .catch { e ->
                    _uiState.value = UiState.Error(e.toString())
                }
                .collect {
                    _uiState.value = UiState.Success(it)
                }
        }
    }

}