package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.newsapp.R
import com.example.newsapp.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bottomNavigationView.setupWithNavController(supportFragmentManager.findFragmentById(R.id.newsNavHostFragmentt)!!.findNavController() )


    }

}