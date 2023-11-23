package br.com.fundatec.fundatecheroti22.login.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.fundatecheroti22.R
import br.com.fundatec.fundatecheroti22.login.domain.LoginUseCase
import br.com.fundatec.fundatecheroti22.login.presentation.model.LoginViewState
import kotlinx.coroutines.launch


class LoginViewModel : ViewModel() {


    private val useCase by lazy {
        LoginUseCase()
    }

    private val viewState: MutableLiveData<LoginViewState> = MutableLiveData()
    val state: LiveData<LoginViewState> = viewState



    private val passwordState: MutableLiveData<String> = MutableLiveData()
    val password: LiveData<String> = passwordState


    fun validacaoPreenchimento(
        email: String,
        password: String
    ) {
        if (email.isNullOrBlank()) {
            viewState.value = LoginViewState.ShowEmailError
            return
        }

        if (password.isNullOrBlank()) {
            viewState.value = LoginViewState.ShowPasswordError
            return
        }
        viewModelScope.launch {
            val isValidUser = useCase.login(email = email, password = password)
            if (isValidUser) {
                viewState.value = LoginViewState.ShowHomeScreen
            }
        }
    }
}
