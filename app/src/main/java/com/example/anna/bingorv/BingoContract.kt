package com.example.anna.bingorv

import com.example.anna.bingorv.model.ResourcesStringSource

interface BingoContract {
    interface Presenter{

        fun setItems(list: List<String>)
        fun getItems():ResourcesStringSource?
        fun bind(view:View)
        fun unbind()
        fun notifyItemClicked(position: Int)
    }

    interface View{

        fun markItemAsFound(position:Int)
        fun loadItems(): ResourcesStringSource? {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}