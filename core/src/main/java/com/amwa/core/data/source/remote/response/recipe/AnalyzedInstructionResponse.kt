package com.amwa.core.data.source.remote.response.recipe


import com.google.gson.annotations.SerializedName

data class AnalyzedInstructionResponse(
    @SerializedName("steps")
    val steps: List<StepResponse>
)