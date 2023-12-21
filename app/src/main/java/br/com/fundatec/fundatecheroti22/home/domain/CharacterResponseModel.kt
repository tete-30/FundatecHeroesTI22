package br.com.fundatec.fundatecheroti22.home.domain

import br.com.fundatec.fundatecheroti22.createCharacter.data.remote.CharacterResponse

fun List<CharacterResponse>.toModel(): List<CharacterModel> {
        return map { character ->
            CharacterModel(
                id = character.id,
                name = character.name,
                image = character.image,
                description = character.description,
                birthday = character.birthday.orEmpty(),
                age = character.age
            )
        }
    }
