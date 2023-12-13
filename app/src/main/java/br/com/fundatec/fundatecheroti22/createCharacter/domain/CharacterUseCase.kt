package br.com.fundatec.fundatecheroti22.createCharacter.domain

import br.com.fundatec.fundatecheroti22.createCharacter.data.remote.CharacterResponse
import br.com.fundatec.fundatecheroti22.createCharacter.data.repository.CharacterRepository
import java.time.LocalDateTime

class CharacterUseCase {
    private val repository by lazy {
        CharacterRepository()
    }

    suspend fun createCharacter(
        name:String,
        description: String,
        image: String,
        universeType: String,
        characterType: String,
        age: Int,
        birthday: LocalDateTime?
    ): Boolean {
        return repository.createCharacter(
            name = name,
            description = description,
            image = image,
            universeType = universeType,
            characterType = characterType,
            age = age,
            birthday = birthday
        )
    }

    suspend fun listCharacter(): List<CharacterResponse> {
        return repository.listCharacter();
    }

}