package com.example.eportal.adapter.slideshow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eportal.R
import java.util.ArrayList

class UserListAdapter(private val usersArrayList: ArrayList<String>) : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_userlist, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return usersArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = usersArrayList[position]
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val textView : TextView
        init {
            textView = view.findViewById(R.id.userName)
        }
    }

}
