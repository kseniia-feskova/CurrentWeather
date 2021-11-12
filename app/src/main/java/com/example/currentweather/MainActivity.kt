package com.example.currentweather


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.currentweather.databinding.ActivityMainBinding
import com.example.currentweather.databinding.TodayFragmentBinding
import com.example.currentweather.fragments.today.TodayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var todayBinding: TodayFragmentBinding

    private lateinit var navController: NavController

    private val viewModel: TodayViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBar)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        binding.bottomNav.setupWithNavController(navController)
        NavigationUI.setupActionBarWithNavController(this, navController)

        viewModel.todayWeatherResponse.observe(this, { TodayWeatherResponse ->
            todayBinding.apply {
                temperature.text = TodayWeatherResponse.temperature
                description.text = TodayWeatherResponse.description
                wind.text = TodayWeatherResponse.wind
            }
        })
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}