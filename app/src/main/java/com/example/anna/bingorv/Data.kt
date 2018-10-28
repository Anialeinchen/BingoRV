package com.example.anna.bingorv

class Data(var data: List<String> = emptyList()) {

    var currentData = listOf("Fowler", "Beck", "Evans")
    init {
        if (data.isNotEmpty()) currentData = data
    }
}