package com.amwa.myrecipe.menu.home

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.amwa.core.data.Resource
import com.amwa.core.domain.model.recipe.Recipe
import com.amwa.core.extension.invisible
import com.amwa.core.extension.showShortToast
import com.amwa.core.extension.visible
import com.amwa.core.ui.RecipeAdapter
import com.amwa.myrecipe.R
import com.amwa.myrecipe.databinding.FragmentHomeBinding
import com.amwa.myrecipe.menu.MenuFragment
import com.amwa.myrecipe.menu.MenuFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
@FlowPreview
@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home), RecipeAdapter.Interaction {

    private val viewModel by viewModels<HomeViewModel>()

    private var binding: FragmentHomeBinding? = null

    private val recipeAdapter: RecipeAdapter by lazy {
        RecipeAdapter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)

        initSearchView()
        initListView()
        initObservers()
    }

    private fun initSearchView() {
        binding?.etSearch?.apply {
            doOnTextChanged { text, start, before, count ->
                if (text.isNullOrBlank()) {
                    viewModel.getAllRecipes()
                } else {
                    lifecycleScope.launch {
                        viewModel.queryChannel.send(text.toString())
                    }
                }
            }
        }
    }

    private fun initListView() {
        binding?.rvRecipe?.apply {
            adapter = recipeAdapter
            setHasFixedSize(true)
        }
    }

    private fun initObservers() {
        viewModel.recipeList.observe(viewLifecycleOwner, {
            val resource = it ?: return@observe

            when (resource) {
                is Resource.Success -> {
                    binding?.progressBar?.invisible()
                    resource.data?.let { data ->
                        recipeAdapter.submitList(data)
                    }
                }
                is Resource.Loading -> binding?.progressBar?.visible()
                is Resource.Error -> {
                    binding?.progressBar?.invisible()
                    showShortToast(resource.message)
                }
            }
        })

        viewModel.searchResult.observe(viewLifecycleOwner, {
            val resource = it ?: return@observe

            when (resource) {
                is Resource.Success -> {
                    binding?.progressBar?.invisible()
                    if (!binding?.etSearch?.text.isNullOrBlank()) {
                        resource.data?.let { data ->
                            val ids = data.map { autocomplete -> autocomplete.id }.toIntArray()
                            if (ids.isEmpty()) {
                                recipeAdapter.submitList(emptyList())
                            } else {
                                viewModel.getRecipes(ids)
                            }
                        }
                    }
                }
                is Resource.Loading -> binding?.progressBar?.visible()
                is Resource.Error -> {
                    binding?.progressBar?.invisible()
                    showShortToast(resource.message)
                }
            }
        })
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    override fun onItemSelected(position: Int, item: Recipe) {
        val direction = MenuFragmentDirections.actionMenuFragmentToDetailFragment(item)
        val navHostFragment = parentFragment as NavHostFragment
        val parentFragment = navHostFragment.parentFragment as MenuFragment
        parentFragment.navigate(direction)
    }
}
