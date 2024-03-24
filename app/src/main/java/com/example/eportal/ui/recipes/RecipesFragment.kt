package com.example.eportal.ui.recipes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.eportal.adapter.RecipesListAdapter
import com.example.eportal.databinding.FragmentRecipesBinding
import com.example.eportal.model.ResultsItem
import com.example.eportal.utils.Constant

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

        //Recycler View setup
        val userListRecyclerView : RecyclerView = binding.recyclerView
        val linearLayoutManager = LinearLayoutManager(activity)
        userListRecyclerView.layoutManager = linearLayoutManager

    }

    private fun subscribe() {
        recipesViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            // Is sending the API request
            Log.d("DATA",isLoading.toString())
            binding.progressBar.visibility = View.VISIBLE
        }

        recipesViewModel.isError.observe(viewLifecycleOwner) { isError ->
            // Encountered an error in the process
            Constant.errorDialog(requireActivity(),"Network Issue!")
        }

        recipesViewModel.recipesData.observe(viewLifecycleOwner) { recipesData ->
            // Display weather data to the UI
            binding.progressBar.visibility = View.GONE
            Log.d("TAG",recipesData.results.toString())
            setRecipesData(recipesData.results)
        }
    }

    private fun setRecipesData(recipesData: List<ResultsItem?>?) {
        val adapter = RecipesListAdapter(recipesData)
        binding.recyclerView.adapter = adapter
    }
}