package br.com.fundatec.fundatecheroti22.home.presentation.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.fundatecheroti22.createCharacter.domain.CharacterUseCase
import br.com.fundatec.fundatecheroti22.home.domain.toModel
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val useCase by lazy {
        CharacterUseCase()
    }

    private val viewState: MutableLiveData<HomeViewState> = MutableLiveData()
    val state: LiveData<HomeViewState> = viewState

    private var lastCacheTime: Long = 0


    // Buscar personagens na API
    private fun fetchCharacterAPI() {
        viewModelScope.launch {
            val listCharacter = useCase.listCharacter()
            if (listCharacter.isNotEmpty()) {
                viewState.value = HomeViewState.Success(listCharacter.toModel())
            } else {
                viewState.value = HomeViewState.Error("Lista de personagens Vazia")
            }
        }
    }

    // Remover personagem na API
    fun deleteCharacter(characterId: Int) {
        viewModelScope.launch {
            val characterDelete = useCase.removerCharacter(characterId)
            if (characterDelete) {
                viewState.value = HomeViewState.removerCharacter;
            } else {
                viewState.value = HomeViewState.Error("Não existe personagem com o ID informado.")
            }
        }
    }

    init {
        fetchCharacterAPI()
    }
}