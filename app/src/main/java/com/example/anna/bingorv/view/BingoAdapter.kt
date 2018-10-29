package com.example.anna.bingorv.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.anna.bingorv.R
import kotlinx.android.synthetic.main.item_layout.view.*

class BingoAdapter(bingoList:List<String>) : RecyclerView.Adapter<BingoAdapter.BingoViewHolder>(){

    var currentBingoList = bingoList
    var onItemClickListener:OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BingoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return BingoViewHolder(view)
    }

    override fun onBindViewHolder(holder: BingoViewHolder, position: Int) {
        holder.view.bingo_item.text = currentBingoList[position]
        holder.view.setOnClickListener { onItemClickListener?.onItemClick(holder.adapterPosition) }
    }

    override fun getItemCount() = currentBingoList.size

    fun updateList(newList:List<String>){currentBingoList = newList}

    class BingoViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}