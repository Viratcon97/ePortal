package com.example.eportal.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eportal.R
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

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.recipeTitle.text = recipesList?.get(position)?.name
        holder.recipeOrigin.text = recipesList?.get(position)?.country
        holder.nutritionFiberText.text = "Fiber - " + recipesList?.get(position)?.nutrition?.fiber.toString()
        holder.nutritionSugarText.text = "Sugar - " + recipesList?.get(position)?.nutrition?.sugar.toString()
        holder.nutritionProteinText.text = "Protein - " + recipesList?.get(position)?.nutrition?.protein.toString()
        holder.nutritionFatText.text = "Fat - " + recipesList?.get(position)?.nutrition?.fat.toString()
        holder.nutritionCaloriesText.text = "Calories - "+recipesList?.get(position)?.nutrition?.calories.toString()
        recipesList?.get(position)?.credits?.forEach { credits ->
            holder.creditName.text = "Credit - " + credits?.name.toString()
        }
    }
    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val recipeTitle = recipesListBinding.textViewRecipeTitle
        val recipeOrigin = recipesListBinding.textViewOriginCountry
        val nutritionProteinText = recipesListBinding.textViewProtein
        val nutritionFatText = recipesListBinding.textViewFat
        val nutritionCaloriesText = recipesListBinding.textViewCalories
        val nutritionFiberText = recipesListBinding.textViewFiber
        val nutritionSugarText = recipesListBinding.textViewSugar
        val creditName = recipesListBinding.textViewCredit
    }
}
