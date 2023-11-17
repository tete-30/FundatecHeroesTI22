package br.com.fundatec.fundatecheroti22.database

import androidx.databinding.adapters.Converters
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.fundatec.fundatecheroti22.App
import br.com.fundatec.fundatecheroti22.login.data.local.UserDao
import br.com.fundatec.fundatecheroti22.login.data.local.UserEntity

@Database(entities = [UserEntity::class], version = 2)
@TypeConverters(Converters::class)
abstract class FHDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        fun getInstance(): FHDataBase {
            return databaseBuilder(
                App.context,
                FHDataBase::class.java,
                "fh.database"
            ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        }
    }
}