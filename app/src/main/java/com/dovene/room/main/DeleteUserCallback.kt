package com.dovene.room.main

import com.dovene.room.model.User


interface DeleteUserCallback {
    fun onDelete(user: User)
}