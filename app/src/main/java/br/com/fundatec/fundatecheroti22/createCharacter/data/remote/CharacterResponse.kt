package br.com.fundatec.fundatecheroti22.createCharacter.data.remote

class CharacterResponse (
    val id: Int,
    val name:String,
    val description: String,
    val image: String,
    val universeType: String,
    val characterType: String,
    val age: Int,
    val birthday: String?
)