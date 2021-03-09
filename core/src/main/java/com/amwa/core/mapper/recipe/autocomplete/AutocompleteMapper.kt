package com.amwa.core.mapper.recipe.autocomplete

import com.amwa.core.data.source.remote.response.recipe.autocomplete.AutocompleteResponse
import com.amwa.core.domain.model.recipe.autocomplete.Autocomplete
import com.amwa.core.mapper.DomainMapper

object AutocompleteResponseMapper : DomainMapper<AutocompleteResponse, Autocomplete> {
    override fun mapToDomain(type: AutocompleteResponse) = with(type) { Autocomplete(id) }
}