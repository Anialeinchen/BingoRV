package com.example.anna.bingorv

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_layout.view.*

class BingoAdapter(val data: Data) : RecyclerView.Adapter<BingoAdapter.BingoViewHolder>() {

    class BingoViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BingoAdapter.BingoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return BingoAdapter.BingoViewHolder(view)
    }

    override fun onBindViewHolder(holder: BingoAdapter.BingoViewHolder, position: Int) {
        holder.view.bingo_item.text = data.currentData[position]
        holder.view.setOnClickListener {
            holder.view.bingo_item.text = "found"
        }
    }

    override fun getItemCount() = data.currentData.size
}