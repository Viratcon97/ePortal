package com.example.eportal.adapter.slideshow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eportal.R
import com.example.eportal.ui.slideshow.User

class UserListAdapter(private val usersArrayList: MutableList<User>) : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_userlist, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return usersArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewName.text = usersArrayList[position].name
        holder.textViewCityName.text = usersArrayList[position].city
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val textViewName : TextView
        val textViewCityName : TextView
        init {
            textViewName = view.findViewById(R.id.userName)
            textViewCityName = view.findViewById(R.id.userCity)
        }

    }

}
