package com.example.eportal.ui.weather

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.eportal.databinding.FragmentWeatherBinding
import com.example.eportal.model.WeatherResponse
import com.squareup.picasso.Picasso

class WeatherFragment : Fragment() {

    private var _binding: FragmentWeatherBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var weatherViewModel : WeatherViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        weatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
        weatherViewModel.getWeatherData("new york")
        subscribe()

    }

    private fun subscribe() {
        weatherViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            // Is sending the API request
            binding.progressBar.visibility = View.VISIBLE
        }

        weatherViewModel.isError.observe(viewLifecycleOwner) { isError ->
            // Encountered an error in the process
            Log.d("DATA",isError.toString())

        }

        weatherViewModel.weatherData.observe(viewLifecycleOwner) { weatherData ->
            // Display weather data to the UI
            binding.progressBar.visibility = View.GONE
            setData(weatherData)
        }
    }

    private fun setData(weatherData: WeatherResponse) {

        "Feels Like - ${weatherData.current?.feelslikeC}".also { binding.textFeelsLike.text = it }
        "Country - ${weatherData.location?.country}".also { binding.textCountry.text = it }
        "City - ${weatherData.location?.name}".also { binding.textCity.text = it }
        //weatherData.current.condition.icon
        val imagePath = weatherData.current?.condition?.icon
        if (imagePath.equals("")){
            Toast.makeText(requireActivity(),"No picture found",Toast.LENGTH_LONG).show()
        }else{
            Picasso.get().load(imagePath).into(binding.imageViewWeather)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}