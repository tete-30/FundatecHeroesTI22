package br.com.fundatec.fundatecheroti22.createCharacter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fundatec.fundatecheroti22.R
import br.com.fundatec.fundatecheroti22.databinding.ActivityCharacterDetailsBinding
import br.com.fundatec.fundatecheroti22.home.domain.CharacterModel
import com.bumptech.glide.Glide

class CharacterDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val character = intent.extras?.getSerializable("character") as? CharacterModel
        if (character == null){
            finish()
            return
        }
        Glide.with(binding.root.context)
            .load(character.image)
            .into(binding.ivCharacter)
        binding.tvName.text = character.name
        binding.tvDescricao.text = character.description
        binding.tvIdade.text = character.age.toString()
        binding.tvNascimento.text =  getString(R.string.dataNasc, character.birthday)

    }

}