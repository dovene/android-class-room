package com.dovene.room.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.dovene.room.R
import com.dovene.room.model.User


class UsersRecyclerViewAdapter(var users: MutableList<User>, var deleteCallback: DeleteUserCallback): Adapter<UsersViewHolder>() {

    override fun getItemCount(): Int {
        return  users.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.list_item, parent, false)
        return UsersViewHolder(view)
    }


    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bind(users[position], deleteCallback)
    }
}