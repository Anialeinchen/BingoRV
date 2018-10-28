package com.example.anna.bingorv

import android.content.Context

class Data(context: Context) {
    var data: List<String> = context
        .resources
        .getStringArray(R.array.bingo_array)
        .toList()

    var currentData = listOf(
        context.getString(R.string.dummy_data_1),
        context.getString(R.string.dummy_data_2),
        context.getString(R.string.dummy_data_3)
    )

    init {
        if (data.isNotEmpty()) currentData = data
    }
}