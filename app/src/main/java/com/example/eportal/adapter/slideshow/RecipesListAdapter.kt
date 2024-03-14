package com.example.eportal.adapter.slideshow

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eportal.databinding.LayoutRecipesBinding
import com.example.eportal.model.ResultsItem

class RecipesListAdapter(private val recipesList: List<ResultsItem?>?) :
    RecyclerView.Adapter<RecipesListAdapter.ViewHolder>() {

    private lateinit var recipesListBinding : LayoutRecipesBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        recipesListBinding = LayoutRecipesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(recipesListBinding.root)
    }

    override fun getItemCount(): Int {
        return recipesList!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        recipesList?.get(position)?.toString()?.let { Log.d("ADAPTER", it) }
        holder.text.text = recipesList?.get(position)?.toString()
    }
    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val text = recipesListBinding.textView
    }
}
