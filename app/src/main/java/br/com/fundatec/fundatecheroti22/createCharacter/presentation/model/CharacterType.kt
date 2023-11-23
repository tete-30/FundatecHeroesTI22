package br.com.fundatec.fundatecheroti22.createCharacter.presentation.model

enum class CharacterType {

    HEROI, VILAO;

    companion object {
        fun getValueOf(position: Int): String {
            return when (position) {
                1 -> HEROI.name
                2 -> VILAO.name
                else -> throw IllegalArgumentException("Posição inválida")
            }
        }
    }
}