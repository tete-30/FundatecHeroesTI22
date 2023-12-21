package br.com.fundatec.fundatecheroti22.createCharacter.data.repository

import br.com.fundatec.fundatecheroti22.createCharacter.data.CharacterRequest
import br.com.fundatec.fundatecheroti22.createCharacter.data.remote.CharacterResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CharacterService {
    @POST("/api/character/{idUser}")
    suspend fun createCharacter(
        @Path("idUser") idUser: Int,
        @Body characterRequest: CharacterRequest
    ): Response<ResponseBody>

    @GET("/api/character/{idUser}")
    suspend fun listCharacter(
        @Path("idUser") idUser: Int,
    ): Response<List<CharacterResponse>>

    @DELETE("/api/character/{idCharacter}")
    suspend fun removerCharacter(
        @Path("idCharacter") idUser: Int,
    ): Response<ResponseBody>
}


