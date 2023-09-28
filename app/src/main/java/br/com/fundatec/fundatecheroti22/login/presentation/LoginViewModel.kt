package br.com.fundatec.fundatecheroti22.login.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import br.com.fundatec.fundatecheroti22.R

class LoginViewModel : ViewModel() {

    fun validateInputs(email: String?, password: String?) {
        Log.e("teste",email.toString())
        Log.e("teste",password.toString())

    }

}