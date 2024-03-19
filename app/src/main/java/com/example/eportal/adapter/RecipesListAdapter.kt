package com.example.eportal.adapter

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
        holder.recipeTitle.text = recipesList?.get(position)?.name
        holder.recipesDescription.text = recipesList?.get(position)?.country
        holder.recipesNutrition.text = recipesList?.get(position)?.nutrition.toString()
        holder.nutritionProteinText.text = recipesList?.get(position)?.nutrition?.protein.toString()
        holder.nutritionFatText.text = recipesList?.get(position)?.nutrition?.fat.toString()
        holder.nutritionCaloriesText.text = recipesList?.get(position)?.nutrition?.calories.toString()
    }
    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val recipeTitle = recipesListBinding.textViewRecipeTitle
        val recipesDescription = recipesListBinding.textViewRecipesDescription
        val recipesNutrition = recipesListBinding.textViewNutrition
        val nutritionProteinText = recipesListBinding.textViewProtein
        val nutritionFatText = recipesListBinding.textViewFat
        val nutritionCaloriesText = recipesListBinding.textViewCalories
    }
}
