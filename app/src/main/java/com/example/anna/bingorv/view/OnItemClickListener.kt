package com.example.anna.bingorv.view

interface OnItemClickListener{

    fun onItemClick(index:Int)
    fun markItemAsClicked(position:Int)
    fun refreshUi()
}