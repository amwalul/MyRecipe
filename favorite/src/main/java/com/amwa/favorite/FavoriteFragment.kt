package com.amwa.favorite

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.amwa.core.domain.model.recipe.Recipe
import com.amwa.core.ui.RecipeAdapter
import com.amwa.favorite.databinding.FragmentFavoriteBinding
import com.amwa.favorite.di.DaggerFavoriteComponent
import com.amwa.myrecipe.di.FavoriteModuleDependencies
import com.amwa.myrecipe.menu.MenuFragment
import com.amwa.myrecipe.menu.MenuFragmentDirections
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteFragment : Fragment(R.layout.fragment_favorite), RecipeAdapter.Interaction {

    @Inject
    lateinit var viewModel: FavoriteViewModel

    private var binding: FragmentFavoriteBinding? = null

    private val recipeAdapter: RecipeAdapter by lazy {
        RecipeAdapter(this)
    }

    override fun onAttach(context: Context) {
        DaggerFavoriteComponent.factory().create(
            EntryPointAccessors.fromActivity(
                requireActivity(),
                FavoriteModuleDependencies::class.java
            )
        ).inject(this)

        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFavoriteBinding.bind(view)

        initListView()
        initObservers()
    }

    private fun initListView() {
        binding?.rvRecipe?.apply {
            adapter = recipeAdapter
            setHasFixedSize(true)
        }
    }

    private fun initObservers() {
        viewModel.recipeList.observe(viewLifecycleOwner, {
            val recipeList = it ?: return@observe
            recipeAdapter.submitList(recipeList)
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