package com.example.eportal.ui.home

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.eportal.databinding.FragmentHomeBinding
import com.example.eportal.databinding.FragmentRecipesBinding

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

        val timer = object  : CountDownTimer(5000,100){
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