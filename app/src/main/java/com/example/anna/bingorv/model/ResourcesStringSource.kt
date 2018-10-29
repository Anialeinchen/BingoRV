package com.example.anna.bingorv.model

import android.content.Context
import com.example.anna.bingorv.R

class ResourcesStringSource(context: Context):StringSource {

    private var bingoFeatureItems: List<String> =
        context
        .resources
        .getStringArray(R.array.bingo_array)
        .toList()

    private var currentBingoFeatureItems = listOf(
        context.getString(R.string.dummy_data_1),
        context.getString(R.string.dummy_data_2),
        context.getString(R.string.dummy_data_3)
    )

    init {
        if (bingoFeatureItems.isNotEmpty()) currentBingoFeatureItems = bingoFeatureItems
    }

    override fun getBingoItems():List<String> { return currentBingoFeatureItems }
}