package br.com.fundatec.fundatecheroti22.profile.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fundatec.fundatecheroti22.R
import androidx.activity.viewModels
import br.com.fundatec.fundatecheroti22.databinding.ActivityProfileBinding
import br.com.fundatec.fundatecheroti22.profile.presentation.model.ProfileViewModel
import br.com.fundatec.fundatecheroti22.profile.presentation.model.ProfileViewState.*
import com.google.android.material.snackbar.Snackbar

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FundatecHeroTI22)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.state.observe(this) {
            when (it) {
                Success -> {
                    showSnackMessage("Sucesso ao criar o usuário")
                    finish()

                }
                Error ->
                    showSnackMessage("Ocorreu um erro ao criar o usuário")
                Loading -> TODO()
                ShowNameError ->
                    showNameError()

                ShowEmailError ->
                    showEmailError()

                ShowPasswordError ->
                    showPasswordError()
            }
        }

        configBtCreateUser()
    }

    private fun configBtCreateUser() {
        binding.buttonCreate.setOnClickListener {
            viewModel.validateInputs(
                name = binding.editTextName.text.toString(),
                email = binding.editTextEmail.text.toString(),
                password = binding.editTextPassword.text.toString(),
            )
        }
    }

    private fun showNameError() {
        binding.editTextName.error = getString(R.string.email_error)
    }

    private fun showEmailError() {
        binding.editTextEmail.error = getString(R.string.email_error)
    }

    private fun showPasswordError() {
        binding.editTextPassword.error = getString(R.string.password_error)
    }

    private fun showSnackMessage(message: String) {
        Snackbar.make(
            binding.root,
            message,
            Snackbar.LENGTH_LONG
        ).show()
    }
}