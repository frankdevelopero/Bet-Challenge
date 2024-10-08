package com.apuestatotal.app.presentation.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apuestatotal.app.data.model.request.SignInRequest
import com.apuestatotal.app.data.remote.ApiResponse
import com.apuestatotal.app.domain.entity.UserEntity
import com.apuestatotal.app.domain.usecase.SignInUseCase
import com.apuestatotal.app.utils.ErrorGeneric
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
) : ViewModel() {

    private val _user = MutableLiveData<UserEntity>()
    val user: LiveData<UserEntity> = _user

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<ErrorGeneric?>()
    val error: LiveData<ErrorGeneric?> = _error

    fun signIn(email: String, password: String, fcmToken: String) {
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _error.postValue(ErrorGeneric(0, "", "Por favor, ingresa un correo electrónico válido."))
            return
        }

        if (password.isEmpty()) {
            _error.postValue( ErrorGeneric(0, "", "Por favor, ingresa tu contraseña."))
            return
        }


        viewModelScope.launch {


            _isLoading.postValue(true)

            val signInRequest = SignInRequest(email, password, fcmToken)

            when (val response = signInUseCase(signInRequest)) {
                is ApiResponse.Success -> {
                    _user.postValue(response.value)
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
