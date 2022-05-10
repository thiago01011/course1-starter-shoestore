package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding
    private lateinit var viewModel: AppViewModel
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupDataBinding()
        setupViewModel()
        setupNavigation()

        Timber.plant(Timber.DebugTree())
    }

    private fun setupNavigation() {
        val navController = this.findNavController(R.id.navHostFragment)
        appBarConfiguration = AppBarConfiguration(navController.graph)

        setSupportActionBar(dataBinding.toolbar)
    }

    private fun setupViewModel() {
        // Initializing view model
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
    }

    private fun setupDataBinding() {
        // Initializing data binding
        dataBinding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        )
    }
}
