package com.example.eportal.ui.home

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.eportal.databinding.FragmentHomeBinding
import com.example.eportal.databinding.FragmentRecipesBinding
import com.example.eportal.utils.Constant.Companion.CREDENTIAL
import java.time.LocalDateTime
import java.util.Date
import java.util.Timer

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var homeViewModel : HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        //Login Status Shared preference
        val sharedPreference = requireActivity().getSharedPreferences(CREDENTIAL, Context.MODE_PRIVATE)
        val loginStatus = sharedPreference.getBoolean("loginStatus", false)
        Toast.makeText(requireActivity(),loginStatus.toString(),Toast.LENGTH_LONG).show()

        //Current Date time
        val date = LocalDateTime.now()
        binding.textCurrentDateTime.text = date.toString()

        //Timer
        val timer = object  : CountDownTimer(1000,1){
            override fun onTick(millisUntilFinished: Long) {
                binding.textHome.text = millisUntilFinished.toString()
            }

            override fun onFinish() {
                binding.textHome.text = "Task Completed!"
            }
        }
        timer.start()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}