package com.example.anna.bingorv.presenter

import com.example.anna.bingorv.BingoContract
import com.example.anna.bingorv.model.ResourcesStringSource

class BingoPresenter: BingoContract.Presenter {
    override fun setItems(list: List<String>) {
        //TODO implement saving to a file or to SharedPreferences
    }

    var view:BingoContract.View? = null

    override fun getItems(): ResourcesStringSource? { return view?.loadItems() }

    override fun bind(view: BingoContract.View) { this.view = view }

    override fun unbind() { view = null }

    override fun notifyItemClicked(position: Int) { view?.markItemAsFound(position) }
}