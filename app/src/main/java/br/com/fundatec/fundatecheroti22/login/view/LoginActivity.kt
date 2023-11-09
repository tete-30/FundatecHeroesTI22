package br.com.fundatec.fundatecheroti22.login.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.fundatecheroti22.R
import br.com.fundatec.fundatecheroti22.databinding.ActivityLoginBinding
import br.com.fundatec.fundatecheroti22.home.view.HomeActivity
import br.com.fundatec.fundatecheroti22.login.presentation.LoginViewModel
import br.com.fundatec.fundatecheroti22.login.presentation.model.LoginViewState
import br.com.fundatec.fundatecheroti22.profile.view.ProfileActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FundatecHeroTI22)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configLoginButton()
        configNewHereButton()

        viewModel.state.observe(this) {
            when (it) {
                is LoginViewState.Success -> TODO()
                is LoginViewState.Error -> TODO()
                LoginViewState.Loading -> TODO()
                LoginViewState.ShowEmailError -> showEmailError()
                LoginViewState.ShowPasswordError -> showPasswordError()
                LoginViewState.ShowHomeScreen -> TODO()
                LoginViewState.ShowEmailPasswordError -> TODO()
            }
        }
    }


    private fun configLoginButton() {
        binding.loginButton.setOnClickListener {
            viewModel.validacaoPreenchimento(
                binding.email.text.toString(),
                binding.password.text.toString()
            )
            startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
        }
    }

    private fun configNewHereButton() {
        binding.newHereTextView.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ProfileActivity::class.java))
        }
    }

    private fun showEmailError() {
        binding.tilEmail.error = getString(R.string.email_error)
        getString(R.string.email_error) // Alterei de "emailEdit" para "tilEmail"
    }

    private fun showPasswordError() {
        binding.tilPassword.error = getString(R.string.password_error)
        getString(R.string.password_error) // Alterei de "passwordEdit" para "tilPassword"
    }
}

