package com.dovene.room.main

import android.content.Context
import androidx.lifecycle.LiveData

import androidx.lifecycle.ViewModel
import com.dovene.room.model.User
import com.dovene.room.repository.UserRepository


class UserViewModel(context: Context) : ViewModel() {
    private var userRepository: UserRepository = UserRepository(context)
    private val allUsers: LiveData<List<User>> = userRepository.allUsers

    fun insert(user: User) {
        userRepository.insert(user)
    }

    fun delete(user: User) {
        userRepository.delete(user)
    }

    fun getAllUser():LiveData<List<User>>{
        return allUsers
    }

}