package com.dovene.room.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.dovene.room.data.AppDatabase
import com.dovene.room.data.UserDao
import com.dovene.room.model.User

class UserRepository(context: Context) {
    private lateinit var userDao: UserDao
    private lateinit var usersLiveData: LiveData<List<User>>

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allUsers: LiveData<List<User>>
        get() = usersLiveData

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    fun insert(user: User) {
        AppDatabase.databaseWriteExecutor.execute { userDao.insert(user) }
    }

    init {
        val db = AppDatabase.getDatabase(context = context)
        if (db != null) {
            userDao = db.userDao()!!
            usersLiveData = userDao.getAll()
        }

    }
}