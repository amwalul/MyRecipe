package com.amwa.myrecipe.menu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.amwa.myrecipe.R
import com.amwa.myrecipe.databinding.FragmentMenuBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : Fragment(R.layout.fragment_menu) {

    private var binding: FragmentMenuBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMenuBinding.bind(view)
        initBottomNavigationBar()
    }

    private fun initBottomNavigationBar() {
        binding?.apply {
            val navController =
                Navigation.findNavController(requireActivity(), R.id.fragmentNavHostMenu)
            bnvMenu.setupWithNavController(navController)
        }
    }

    fun navigate(direction: NavDirections) {
        findNavController().navigate(direction)
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}