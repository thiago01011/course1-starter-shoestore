package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    private lateinit var dataBinding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setupViewModel()
        setupDataBinding(inflater, container)
        setupButtons()

        return dataBinding.root
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
    }

    private fun setupDataBinding(inflater: LayoutInflater, container: ViewGroup?) {
        dataBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )
        dataBinding.lifecycleOwner = viewLifecycleOwner
        dataBinding.viewModel = viewModel
    }

    private fun setupButtons() {
        dataBinding.loginButton.setOnClickListener {
            moveToNextFragment()
        }

        dataBinding.registerButton.setOnClickListener {
            moveToNextFragment()
        }
    }

    private fun moveToNextFragment() {
        val email = dataBinding.viewModel?.user?.value?.login ?: ""
        val password = dataBinding.viewModel?.user?.value?.password ?: ""
        if (isDataValid(email, password)) {
            view?.findNavController()
                ?.navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())

        } else {
            Toast.makeText(
                requireContext(),
                "Login/Password cannot be empty.",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun isDataValid(email: String, password: String) =
        email.isNotEmpty() && password.isNotEmpty()

}