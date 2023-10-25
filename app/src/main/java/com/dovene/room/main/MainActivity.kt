package com.dovene.room.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dovene.room.databinding.ActivityMainBinding
import com.dovene.room.model.User
import com.dovene.room.utils.AppViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: UserViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = AppViewModelFactory(this).create(UserViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setViewItems()
        initObservers()
    }

    fun initObservers(){
        viewModel.getAllUser().observe(this) {
            displayList(it)
        }
    }

    fun displayList(users: List<User>) {
        val usersRecyclerViewAdapter  =
            UsersRecyclerViewAdapter(
                users.toMutableList(),
                object : DeleteUserCallback {
                    override fun onDelete(user: User) {
                        delete(user)
                    }
                })
        binding.usersRv.layoutManager = LinearLayoutManager(this)
        binding.usersRv.adapter = usersRecyclerViewAdapter
    }

    private fun delete(user: User) {
        viewModel.delete(user)
    }

    fun setViewItems(){
        binding.addUserBt.setOnClickListener {
            viewModel.insert(User( firstName = binding.firstNameEt.text.toString() , lastName = binding.lastNameEt.text.toString()))
        }
    }
}