package by.tigertosh.newsapp_android.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import by.tigertosh.newsapp_android.R
import by.tigertosh.newsapp_android.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.fragment_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            setContentView(binding.root)
            binding.menuBottomNavigation.setupWithNavController(
                binding.navHostFragment.findNavController()
            )
        }, 2000)


    }

}