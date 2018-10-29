package com.example.anna.bingorv.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.anna.bingorv.BingoContract
import com.example.anna.bingorv.R
import com.example.anna.bingorv.model.BingoRepository
import com.example.anna.bingorv.model.ResourcesStringSource
import com.example.anna.bingorv.model.StringSource
import com.example.anna.bingorv.presenter.BingoPresenter
import java.util.*

//TODO fix flow: click - presenter - update model - presenter - update UI
class MainActivity : AppCompatActivity(), BingoContract.View, OnItemClickListener, StringSource {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: BingoAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var presenter: BingoContract.Presenter
    private lateinit var bingoRepository: BingoRepository
    private var bingoList: List<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchBingoList()
        setUpRecycleView()
        presenter = BingoPresenter()
    }

    private fun fetchBingoList() {
        bingoRepository = BingoRepository(ResourcesStringSource(this))
        bingoList = bingoRepository.getStringSource()
    }

    private fun setUpRecycleView() {
        viewManager = GridLayoutManager(this, 2)
        viewAdapter = BingoAdapter(bingoList)
        viewAdapter.onItemClickListener = this
        recyclerView =
                findViewById<RecyclerView>(R.id.my_recycler_view)
                    .apply {
                        setHasFixedSize(true)
                        layoutManager = viewManager
                        adapter = viewAdapter
                    }
    }

    override fun refreshUi() {
        viewAdapter.notifyDataSetChanged()
    }

    override fun markItemAsClicked(position: Int) {
        //TODO pass here the updated list in some form
        presenter.setItems(bingoList)
        //TODO implement logic for swapping String at this position
        //a result would be the updated list
        markItemAsFound(position)
        refreshUi()
    }

    override fun onItemClick(index: Int) {
        markItemAsClicked(index)
    }

    override fun markItemAsFound(index: Int) {
        //TODO set from Collection<E> is not working
        var newList = bingoList
        var elementToBeRepplaced = bingoList[index]
        if(newList.contains(elementToBeRepplaced)) {
            for(i in 1 until newList.size -1){
                //TODO fix, swap element in array
                // TODO potential bug ==
                if(newList[i] == elementToBeRepplaced){
                    //newList[i] = resources.getString(R.string.done)
                }
            }
        }
        viewAdapter.updateList(newList)
        refreshUi()
    }


    override fun getBingoItems(): List<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onStart() {
        super.onStart()
        presenter.bind(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.unbind()
    }
}
