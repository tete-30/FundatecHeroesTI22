package br.com.fundatec.fundatecheroti22.home.view

import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.fundatecheroti22.databinding.ActivityHomeBinding
import br.com.fundatec.fundatecheroti22.databinding.CharacterListItemBinding
import br.com.fundatec.fundatecheroti22.home.domain.CharacterModel

class CharacterViewHolder (
    private val binding: CharacterListItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(character:CharacterModel){
        binding.tvName.text = character.name
    }


}