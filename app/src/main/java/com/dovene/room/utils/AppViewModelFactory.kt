package com.dovene.room.utils

import android.content.Context
import androidx.lifecycle.ViewModel

import androidx.lifecycle.ViewModelProvider
import com.dovene.room.main.UserViewModel


class AppViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val context: Context = context

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(context) as T
    }
}