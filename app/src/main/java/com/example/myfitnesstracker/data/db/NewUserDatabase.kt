package com.example.myfitnesstracker.data.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class NewUserDatabase: RoomDatabase() {

    abstract fun getNewUserDao() : NewUserDao

    companion object {
        @Volatile
        private var instance: NewUserDatabase? = null

        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NewUserDatabase::class.java,
                "NewUserDB.db"
            ).build()
    }
}