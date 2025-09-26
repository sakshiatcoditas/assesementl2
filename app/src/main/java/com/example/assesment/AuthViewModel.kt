package com.example.assesment



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assesment.repository.AuthRepository
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
    val authState: StateFlow<AuthState> get() = _authState

    fun login(email: String, password: String) {
        if (email.isBlank() || password.isBlank()) {
            _authState.value = AuthState.Error(AuthMessages.EMPTY_EMAIL_PASSWORD)
            return
        }

        viewModelScope.launch {
            _authState.value = AuthState.Loading
            try {
                repository.login(email, password)
                _authState.value = AuthState.Success(AuthMessages.LOGIN_SUCCESS)
            } catch (e: Exception) {
                _authState.value = AuthState.Error(e.message ?: AuthMessages.LOGIN_FAILED)
            }
        }
    }

    fun register(email: String, password: String) {
        if (email.isBlank() || password.isBlank()) {
            _authState.value = AuthState.Error(AuthMessages.EMPTY_EMAIL_PASSWORD)
            return
        }

        viewModelScope.launch {
            _authState.value = AuthState.Loading
            try {
                repository.register(email, password)
                _authState.value = AuthState.Success(AuthMessages.REGISTER_SUCCESS)
            } catch (e: Exception) {
                _authState.value = AuthState.Error(e.message ?: AuthMessages.REGISTER_FAILED)
            }
        }
    }



    fun setAuthStateError(message: String) {
        _authState.value = AuthState.Error(message)
    }


    fun firebaseAuthWithGoogle(account: GoogleSignInAccount) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            try {
                repository.firebaseAuthWithGoogle(account)
                _authState.value = AuthState.Success(AuthMessages.GOOGLE_SUCCESS)
            } catch (e: Exception) {
                _authState.value = AuthState.Error(e.message ?: AuthMessages.GOOGLE_FAILED)
            }
        }
    }
}
