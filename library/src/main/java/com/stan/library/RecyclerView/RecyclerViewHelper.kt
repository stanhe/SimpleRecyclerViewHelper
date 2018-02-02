package com.stan.library.RecyclerView

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * Created by uu on 2018/1/16.
 */

object RecyclerViewHelper {

    fun setupWithLinearLayoutManager(recyclerView: RecyclerView, simpleRecyclerAdapter: SimpleRecyclerAdapter, data: List<*>): SimpleRecyclerAdapter {
        recyclerView.adapter = simpleRecyclerAdapter
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        simpleRecyclerAdapter.setData(data)
        return simpleRecyclerAdapter
    }

    fun setupWithGridLayoutManager(recyclerView: RecyclerView, simpleRecyclerAdapter: SimpleRecyclerAdapter, data: List<*>, span: Int): SimpleRecyclerAdapter {
        recyclerView.adapter = simpleRecyclerAdapter
        recyclerView.layoutManager = GridLayoutManager(recyclerView.context, span)
        simpleRecyclerAdapter.setData(data)
        return simpleRecyclerAdapter
    }

}
