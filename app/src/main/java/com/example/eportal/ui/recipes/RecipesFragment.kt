package com.example.eportal.ui.recipes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.eportal.R
import com.example.eportal.databinding.FragmentRecipesBinding
import com.example.eportal.databinding.FragmentWeatherBinding
import com.example.eportal.ui.weather.WeatherViewModel

class RecipesFragment : Fragment() {

    private var _binding: FragmentRecipesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var recipesViewModel: RecipesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipesViewModel = ViewModelProvider(this).get(RecipesViewModel::class.java)
        recipesViewModel.getRecipesList()
        subscribe()
    }

    private fun subscribe() {
        recipesViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            // Is sending the API request
            Log.d("DATA",isLoading.toString())

        }

        recipesViewModel.isError.observe(viewLifecycleOwner) { isError ->
            // Encountered an error in the process
            Log.d("DATA",isError.toString())

        }

        recipesViewModel.recipesData.observe(viewLifecycleOwner) { recipesData ->
            // Display weather data to the UI
            Log.d("DATA",recipesData.toString())
        }
    }
}