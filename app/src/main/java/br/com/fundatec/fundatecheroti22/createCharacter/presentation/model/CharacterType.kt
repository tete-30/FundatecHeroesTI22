package br.com.fundatec.fundatecheroti22.createCharacter.presentation.model

enum class CharacterType {

    HERO, VILLAIN;

    companion object {
        fun getValueOf(position: Int): String {
            return when (position) {
                1 -> HERO.name
                2 -> VILLAIN.name
                else -> throw IllegalArgumentException("Posição inválida")
            }
        }
    }
}