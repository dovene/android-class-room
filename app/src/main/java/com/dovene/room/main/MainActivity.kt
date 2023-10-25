package com.dovene.room.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.dovene.room.R
import com.dovene.room.model.User
import com.dovene.room.utils.AppViewModelFactory
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = AppViewModelFactory(this).create(UserViewModel::class.java)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.add_user).setOnClickListener {
            viewModel.insert(User(firstName = "toto ${Random(10).nextInt()}" , lastName = "tata"))
        }
        viewModel.getAllUser().observe(this) {
            it.forEach {
                findViewById<TextView>(R.id.user_stats).text =
                    "${findViewById<TextView>(R.id.user_stats).text}  ${it} \n"
            }
        }

    }
}