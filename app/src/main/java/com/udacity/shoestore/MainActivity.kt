package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding
    private lateinit var viewModel: AppViewModel
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initializing data binding
        dataBinding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main)

        // Initializing view model
        viewModel = ViewModelProvider(this).get(AppViewModel::class.java)
        val navController = this.findNavController(R.id.navHostFragment)

        setSupportActionBar(dataBinding.toolbar)
        Timber.plant(Timber.DebugTree())

    }

}
