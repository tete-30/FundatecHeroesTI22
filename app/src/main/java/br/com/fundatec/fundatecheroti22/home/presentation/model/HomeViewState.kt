package br.com.fundatec.fundatecheroti22.home.presentation.model

import br.com.fundatec.fundatecheroti22.home.domain.CharacterModel

sealed class HomeViewState {
    data class Success(val list: List<CharacterModel>) : HomeViewState()
    object Loading : HomeViewState()
    data class Error(val errorMessage: String) : HomeViewState()
    object HideButton : HomeViewState()
    object removerCharacter : HomeViewState()
}