package com.example.fundatecheroes.createCharacter.view

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import br.com.fundatec.fundatecheroti22.R
import br.com.fundatec.fundatecheroti22.databinding.ActivityCreateCharacterBinding

class CreateCharacterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateCharacterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
}