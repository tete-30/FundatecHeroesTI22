package br.com.fundatec.fundatecheroti22.createCharacter.data.repository

import android.util.Log
import br.com.fundatec.fundatecheroti22.createCharacter.data.CharacterRequest
import br.com.fundatec.fundatecheroti22.createCharacter.data.remote.CharacterResponse
import br.com.fundatec.fundatecheroti22.login.data.repository.LoginRepository
import br.com.fundatec.fundatecheroti22.network.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDateTime

class CharacterRepository {

    private val repository = RetrofitNetworkClient.createNetworkClient(
        baseUrl = "https://fundatec.herokuapp.com"
    ).create(CharacterService::class.java)

    private val loginRepository: LoginRepository by lazy {
        LoginRepository()
    }

    suspend fun createCharacter(
        name: String,
        description: String,
        image: String,
        universeType: String,
        characterType: String,
        age: Int,
        birthday: LocalDateTime?): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.createCharacter(
                    idUser = loginRepository.idUsuario(),
                    characterRequest = CharacterRequest(
                        name = name,
                        description = description,
                        image = image,
                        universeType = universeType,
                        characterType = characterType,
                        age = age,
                        birthday = null
                    )
                )
                response.isSuccessful
            } catch (ex: Exception) {
                Log.e("createCharacter", ex.message.toString())
                false
            }
        }
    }

    suspend fun listCharacter(): List<CharacterResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.listCharacter(
                    idUser = loginRepository.idUsuario()
                )
                response.body()?: listOf()
            } catch (ex: Exception) {
                Log.e("listCharacter", ex.message.toString())
                listOf();
            }
        }
    }

    suspend fun removerCharacter(characterId: Int): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.removerCharacter(
                    characterId
                )
                response.code() == 204
            } catch (ex: Exception) {
                Log.e("removerCharacter", ex.message.toString())
                false
            }
        }
    }
}