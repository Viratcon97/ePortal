package com.example.eportal.adapter.slideshow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eportal.databinding.LayoutUserBinding
import com.example.eportal.ui.slideshow.User

class UserListAdapter(private val usersArrayList: MutableList<User>, private val onDeleteClick: (User, Int) -> Unit, private val onEditClick: (User, Int) -> Unit)  : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    lateinit var binding : LayoutUserBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = LayoutUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return usersArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.textViewName.text = usersArrayList[position].name
        holder.textViewCity.text = usersArrayList[position].city
        holder.buttonDelete.setOnClickListener {
            onDeleteClick(usersArrayList[position],position)

        }
        holder.buttonEdit.setOnClickListener {
            onEditClick(usersArrayList[position], position)
        }
    }

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){

        var textViewName = binding.userName
        var textViewCity =binding.userCity
        var buttonDelete = binding.btnDelete
        var buttonEdit = binding.btnEdit
    }

}
