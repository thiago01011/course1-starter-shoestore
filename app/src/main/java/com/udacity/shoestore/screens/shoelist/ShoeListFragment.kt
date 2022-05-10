package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.AppViewModel
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ListItem2Binding
import com.udacity.shoestore.models.Shoe


/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListFragment : Fragment() {

    private lateinit var dataBinding: FragmentShoeListBinding
    private val viewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setupDataBinding(inflater, container)
        setupShoeList()
        setupButtons()
        setupMenu()

        return dataBinding.root
    }

    private fun setupDataBinding(inflater: LayoutInflater, container: ViewGroup?) {
        // Initializing data binding
        dataBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )

        dataBinding.lifecycleOwner = this
    }

    private fun setupShoeList() {
        // Updating the list
        viewModel.shoeListLiveData.observe(viewLifecycleOwner, Observer { shoeListUpdated ->
            if (shoeListUpdated.isNotEmpty()) {
                addItemToList(shoeListUpdated)
            }
        })
    }

    private fun setupButtons() {
        // Going to shoe detail fragment
        dataBinding.addShoeButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_shoeDetailFragment)
        )
    }

    private fun setupMenu() {
        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    private fun addItemToList(shoeList: List<Shoe>) {
        for (shoe in shoeList) {
            val shoeItemListBinding =
                ListItem2Binding.inflate(layoutInflater, dataBinding.listLinearlayout, false)
            shoeItemListBinding.shoeData = shoe
            dataBinding.listLinearlayout.addView(shoeItemListBinding.root)
        }
    }
}