package com.example.myfitnesstracker.data.db

import androidx.room.*
import com.example.myfitnesstracker.data.db.entity.NewUser

@Dao
interface NewUserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(newUser: NewUser)

    @Delete
    suspend fun delete(oldUser: NewUser)

    @Query("SELECT * FROM users_table WHERE user_name = :user")
    fun getDataForUser(user:String)
}