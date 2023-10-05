package br.com.fundatec.fundatecheroti22.login.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fundatec.fundatecheroti22.R
import br.com.fundatec.fundatecheroti22.login.presentation.model.LoginViewState

class LoginViewModel : ViewModel() {

    private val viewState: MutableLiveData<LoginViewState> = MutableLiveData()
    val state: LiveData<LoginViewState> = viewState

    private val passwordState: MutableLiveData<String> = MutableLiveData()
    val password: LiveData<String> = passwordState

    fun validateInputs(email: String?, password: String?) {
        if (email.isNullOrBlank()) {
            viewState.value = LoginViewState.ShowEmailError
        }

        if (password.isNullOrBlank()) {
            viewState.value = LoginViewState.ShowPasswordError
        }

    }

}