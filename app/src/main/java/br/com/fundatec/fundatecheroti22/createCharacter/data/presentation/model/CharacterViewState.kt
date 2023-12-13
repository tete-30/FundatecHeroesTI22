package br.com.fundatec.fundatecheroti22.createCharacter.data.presentation.model

sealed class CharacterViewState {

    object ShowNameError: CharacterViewState()
    object ShowDescriptionError: CharacterViewState()
    object ShowImageError: CharacterViewState()
    object ShowUniverseTypeError: CharacterViewState()
    object ShowCharacterTypeError: CharacterViewState()
    object ShowAgeError: CharacterViewState()
    object ShowBirthdayError: CharacterViewState()
    object ShowHomeScreen: CharacterViewState()

    object ShowGenericError: CharacterViewState()
}
