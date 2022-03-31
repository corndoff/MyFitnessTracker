package com.example.myfitnesstracker.data.repository

import com.example.myfitnesstracker.data.db.NewUserDatabase
import com.example.myfitnesstracker.data.db.entity.NewUser

class NewUserRepository(
    private val db: NewUserDatabase
) {

    suspend fun upsert(user: NewUser) = db.getNewUserDao().upsert(user)

    suspend fun delete(user: NewUser) = db.getNewUserDao().delete(user)

    fun getDataForUser(user: String) = db.getNewUserDao().getDataForUser(user)
}