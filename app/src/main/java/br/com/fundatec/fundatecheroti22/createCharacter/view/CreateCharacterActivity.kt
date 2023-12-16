package com.example.fundatecheroes.createCharacter.view

import android.content.Intent
import android.os.Binder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import br.com.fundatec.fundatecheroti22.R
import br.com.fundatec.fundatecheroti22.createCharacter.presentation.CreateCharacterViewModel
import br.com.fundatec.fundatecheroti22.createCharacter.presentation.model.CharacterViewState
import br.com.fundatec.fundatecheroti22.databinding.ActivityCreateCharacterBinding
import br.com.fundatec.fundatecheroti22.home.view.HomeActivity

class CreateCharacterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateCharacterBinding
    private val viewModel: CreateCharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configButtonNewCharacter()

        val characterTypeSpinner = findViewById<Spinner>(R.id.tipo_personagem)
        val characterTypeAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.tipoPersonagem)
        )
        characterTypeSpinner.adapter = characterTypeAdapter

        val companySpinner = findViewById<Spinner>(R.id.tipo_empresa)
        val companyAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.universeType)


        )
        companySpinner.adapter = companyAdapter
    }

    private fun configButtonNewCharacter() {
        binding.floatingButton.setOnClickListener {
            viewModel.validarPreenchimento(
                name = binding.nameHero.text.toString(),
                description = binding.description.text.toString(),
                image = binding.imgHero.text.toString(),
                characterType = binding.tipoPersonagem.selectedItemPosition,
                universeType = binding.tipoEmpresa.selectedItemPosition,
                age = binding.editTextIdade.text.toString(),
                birthday = binding.etData.text.toString()
            )
        }

        viewModel.state.observe(this){
            when(it) {
                is CharacterViewState.ShowHomeScreen -> {
                    finish()
                }
                    CharacterViewState.ShowError -> {
                        Toast.makeText(this, "Erro ao criar personagem", Toast.LENGTH_SHORT).show()

                }
                else -> {}
            }
        }

    }

}