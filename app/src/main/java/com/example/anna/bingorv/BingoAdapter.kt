package com.example.anna.bingorv

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_layout.view.*

class BingoAdapter(val data: Data) : RecyclerView.Adapter<BingoAdapter.BingoViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class BingoViewHolder(val view: View) : RecyclerView.ViewHolder(view)


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BingoAdapter.BingoViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return BingoAdapter.BingoViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: BingoAdapter.BingoViewHolder, position: Int) {
        holder.view.bingo_item.text = data.currentData[position]
        holder.view.setOnClickListener{
            holder.view.bingo_item.text = "found"
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = data.currentData.size
}