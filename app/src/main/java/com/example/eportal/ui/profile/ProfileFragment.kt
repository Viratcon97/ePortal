package com.example.eportal.ui.profile

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.dd.morphingbutton.MorphingButton
import com.example.eportal.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val profileViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)

        binding.buttonAdd.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val city = binding.editTextCity.text.toString()

            if(name != "" && city != ""){
                //Add Data
                profileViewModel.name.value = name
                profileViewModel.city.value = city
                profileViewModel.displayText()
            }else{
                Toast.makeText(requireActivity(),"Add Data!",Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}