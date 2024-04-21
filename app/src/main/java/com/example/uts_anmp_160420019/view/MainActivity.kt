package com.example.uts_anmp_160420019.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uts_anmp_160420019.R
import com.example.uts_anmp_160420019.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view) //change the argument of setContentView
    }
}