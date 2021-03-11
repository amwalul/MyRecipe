package com.amwa.myrecipe.menu.about

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.amwa.myrecipe.BuildConfig
import com.amwa.myrecipe.R
import com.amwa.myrecipe.databinding.FragmentAboutBinding

class AboutFragment : Fragment(R.layout.fragment_about) {

    private var binding: FragmentAboutBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentAboutBinding.bind(view)
        initAppName()
    }

    private fun initAppName() {
        val appName = getString(R.string.app_name)
        binding?.tvAppName?.text =
            getString(R.string.app_name_format, appName, BuildConfig.VERSION_NAME)
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}