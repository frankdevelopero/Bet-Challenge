package com.apuestatotal.app.presentation.history_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apuestatotal.app.data.remote.ApiResponse
import com.apuestatotal.app.domain.entity.BetHistoryDetailEntity
import com.apuestatotal.app.domain.usecase.GetBetHistoryUseCase
import com.apuestatotal.app.utils.ErrorGeneric
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BetHistoryDetailViewModel @Inject constructor(
    private val getBetHistoryUseCase: GetBetHistoryUseCase
) : ViewModel() {

    private val _betHistory = MutableLiveData<List<BetHistoryDetailEntity>>()
    val betHistory: LiveData<List<BetHistoryDetailEntity>> = _betHistory

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<ErrorGeneric?>()
    val error: LiveData<ErrorGeneric?> = _error

    fun fetchBetHistoryDetail(betId: String) {
        viewModelScope.launch {
            _isLoading.postValue(true)
            when (val response = getBetHistoryUseCase.getBetDetail(betId)) {
                is ApiResponse.Success -> {
                    _betHistory.postValue(response.value)
                    _error.postValue(null)
                }
                is ApiResponse.Error -> {
                    _error.postValue(response.error)
                }
            }
            _isLoading.postValue(false)
        }
    }
}
