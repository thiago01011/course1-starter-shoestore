package com.udacity.shoestore.screens.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.AppViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.login.LoginViewModel
import kotlinx.android.synthetic.main.fragment_shoe_detail.*

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {

    private lateinit var dataBinding: FragmentShoeDetailBinding
    private val appViewModel: AppViewModel by activityViewModels()
    private lateinit var viewModel: ShoeDetailViewModel

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
        viewModel = ViewModelProvider(this)[ShoeDetailViewModel::class.java]
    }

    private fun setupDataBinding(inflater: LayoutInflater, container: ViewGroup?) {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )
        dataBinding.lifecycleOwner = viewLifecycleOwner
        dataBinding.viewModel = viewModel
    }

    private fun setupButtons() {
        dataBinding.cancelButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment)
        )

        dataBinding.saveButton.setOnClickListener {
            val name = dataBinding.viewModel?.shoe?.value?.name ?: ""
            val company = dataBinding.viewModel?.shoe?.value?.company ?: ""

            if (IsDataValid(name, company)) {
                val shoe = dataBinding.viewModel?.shoe?.value
                appViewModel.addShoe(shoe)
                view?.findNavController()
                    ?.navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
            } else {
                Toast.makeText(
                    requireContext(),
                    "Name/Company cannot be empty.",
                    Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun IsDataValid(name: String, company: String) =
        name.isNotEmpty() && company.isNotEmpty()
}