package com.example.myfitnesstracker.data.db.entity

import android.provider.ContactsContract
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class NewUser(
    @ColumnInfo(name = "user_email")
    var email: ContactsContract.CommonDataKinds.Email,

    @ColumnInfo(name = "user_name")
    var username: String,

    @ColumnInfo(name = "user_password")
    var password: String
) {
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
}