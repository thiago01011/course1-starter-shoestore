package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.AppViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.models.User

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    private lateinit var dataBinding: FragmentLoginBinding
    private val viewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setupBinding(inflater, container)
        setupButtons()

        return dataBinding.root
    }

    private fun setupBinding(inflater: LayoutInflater, container: ViewGroup?) {
        dataBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )
        dataBinding.lifecycleOwner = this
        dataBinding.user = User()
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
        val email = dataBinding.user?.login ?: ""
        val password = dataBinding.user?.password ?: ""
        if (dataIsValid(email, password)) {
            viewModel.addUser(dataBinding.user!!)
            view?.findNavController()
                ?.navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())

        } else {
            Toast.makeText(requireContext(), "Login/Password cannot be empty.", Toast.LENGTH_LONG).show()
        }
    }

    private fun dataIsValid(email: String, password: String) =
        email.isNotEmpty() && password.isNotEmpty()


}