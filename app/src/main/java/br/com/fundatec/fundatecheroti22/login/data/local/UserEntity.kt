package br.com.fundatec.fundatecheroti22.login.data.local

import androidx.room.PrimaryKey
import java.util.Date

data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val email: String,
    val password: String,
    val date: Date? = null
)