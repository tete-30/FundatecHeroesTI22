package br.com.fundatec.fundatecheroti22.home.domain

import android.os.Parcelable
import android.view.accessibility.AccessibilityManager.AudioDescriptionRequestedChangeListener
import java.io.Serializable

class CharacterModel(

    val id: Int,
    val name: String,
    val image: String,
    val description: String,
    val age: Int,
    val birthday: String

    ): Serializable