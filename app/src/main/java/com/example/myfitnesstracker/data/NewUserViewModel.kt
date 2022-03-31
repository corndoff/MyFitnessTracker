package com.example.myfitnesstracker.data

import com.example.myfitnesstracker.data.db.entity.NewUser
import com.example.myfitnesstracker.data.repository.NewUserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewUserViewModel(
    private val repository: NewUserRepository
) {
    fun upsert(user: NewUser) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(user)
    }

    fun delete(user: NewUser) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(user)
    }

    fun getDataForUser(user: String) = repository.getDataForUser(user)
}