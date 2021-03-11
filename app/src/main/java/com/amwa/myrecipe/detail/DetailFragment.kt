package com.amwa.myrecipe.detail

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.amwa.core.ui.IngredientAdapter
import com.amwa.core.ui.InstructionAdapter
import com.amwa.myrecipe.R
import com.amwa.myrecipe.databinding.FragmentDetailBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val args by navArgs<DetailFragmentArgs>()

    private val viewModel by viewModels<DetailViewModel>()

    private var binding: FragmentDetailBinding? = null

    private val ingredientAdapter: IngredientAdapter by lazy {
        IngredientAdapter()
    }

    private val instructionAdapter: InstructionAdapter by lazy {
        InstructionAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDetailBinding.bind(view)

        initHeaderView()
        initListViews()
        initObservers()
    }

    private fun initHeaderView() {
        binding?.apply {
            val recipe = args.recipe

            Glide.with(requireView())
                .load(recipe.image)
                .into(ivImage)
            ivImage.contentDescription = recipe.title

            toggleFavorite(recipe.isFavorite)
            btnFavorite.setOnClickListener {
                recipe.isFavorite = !recipe.isFavorite
                viewModel.setFavoriteRecipe(recipe, recipe.isFavorite)
                toggleFavorite(recipe.isFavorite)
            }
            btnFavorite.contentDescription = getString(R.string.favorite_button)

            tvTitle.text = recipe.title
        }
    }

    private fun initListViews() {
        binding?.apply {
            with(args.recipe) {
                rvIngredients.adapter = ingredientAdapter
                ingredientAdapter.submitList(ingredients)

                rvInstructions.adapter = instructionAdapter
                instructionAdapter.submitList(instructions)
            }
        }
    }

    private fun toggleFavorite(isFavorite: Boolean) {
        binding?.btnFavorite?.apply {
            if (isFavorite) {
                setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_baseline_favorite_24
                    )
                )
            } else {
                setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_baseline_favorite_border_24
                    )
                )
            }
        }
    }

    private fun initObservers() {
        viewModel.getSavedRecipe(args.recipe.id).observe(viewLifecycleOwner, {
            val recipe = it ?: return@observe
            toggleFavorite(recipe.isFavorite)
        })
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}