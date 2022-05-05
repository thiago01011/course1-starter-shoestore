package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.AppViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_detail.*

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {

    private lateinit var dataBinding: FragmentShoeDetailBinding
    private val viewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )

        dataBinding.cancelButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment)
        )

        dataBinding.shoe = Shoe()

        dataBinding.saveButton.setOnClickListener { view ->
            if (dataBinding.shoe != null) {
                val shoe = dataBinding.shoe
                viewModel.addShoe(shoe)
                view.findNavController()
                    .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
            }
        }

        return dataBinding.root
    }

}