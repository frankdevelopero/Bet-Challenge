package com.apuestatotal.app.presentation.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apuestatotal.app.data.remote.ApiResponse
import com.apuestatotal.app.domain.entity.BetHistoryEntity
import com.apuestatotal.app.domain.usecase.GetBetHistoryUseCase
import com.apuestatotal.app.utils.ErrorGeneric
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BetHistoryViewModel @Inject constructor(
    private val getBetHistoryUseCase: GetBetHistoryUseCase
) : ViewModel() {

    private val _allBetHistory = MutableLiveData<List<BetHistoryEntity>>()
    private val _betHistory = MutableLiveData<List<BetHistoryEntity>>()
    val betHistory: LiveData<List<BetHistoryEntity>> = _betHistory

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<ErrorGeneric?>()
    val error: LiveData<ErrorGeneric?> = _error

    fun fetchBetHistory() {
        viewModelScope.launch {
            _isLoading.postValue(true)
            when (val response = getBetHistoryUseCase()) {
                is ApiResponse.Success -> {
                    _allBetHistory.postValue(response.value)
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

    fun filterBetHistory(status: String) {
        val allBets = _allBetHistory.value ?: return

        val filteredBets = when (status) {
            "Ganadas" -> allBets.filter { it.status == "WON" }
            "Perdidas" -> allBets.filter { it.status == "LOST" }
            "Abiertas" -> allBets.filter { it.status == "OPEN" }
            else -> allBets
        }

        _betHistory.postValue(filteredBets)
    }

    fun searchBetHistory(eventName: String) {
        val allBets = _allBetHistory.value ?: return

        val filteredBets = allBets.filter {
            it.eventName.contains(eventName, ignoreCase = true)
        }

        _betHistory.postValue(filteredBets)
    }



}
