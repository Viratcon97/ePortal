package com.example.eportal.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.eportal.MainActivity
import com.example.eportal.databinding.ActivitySplashBinding
import com.example.eportal.utils.Constant.Companion.CREDENTIAL

class SplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val timer = object  : CountDownTimer(3000,100){
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {

                val sharedPreference = getSharedPreferences(CREDENTIAL, Context.MODE_PRIVATE)
                val editor = sharedPreference.edit()
                editor.putBoolean("loginStatus", true)
                editor.apply()

                val intent = Intent(this@SplashActivity,MainActivity::class.java)
                startActivity(intent)
            }
        }
        timer.start()
    }

}