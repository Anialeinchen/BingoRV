package com.example.anna.bingorv.model

class BingoRepository(private val stringSource: StringSource) {

    fun getStringSource():List<String>{
        return stringSource.getBingoItems()
    }

}