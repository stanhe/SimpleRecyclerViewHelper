package com.stan.library.RecyclerView

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by uu on 2018/1/16.
 */

abstract class SimpleRecyclerAdapter : RecyclerView.Adapter<SimpleRecyclerAdapter.Holder>() {

    private var data: List<*>? = null

    abstract fun setLayoutId(): Int
    abstract fun bindItemView(root: View, data: List<*>?, position: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleRecyclerAdapter.Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(setLayoutId(), parent, false))
    }

    override fun onBindViewHolder(holder: SimpleRecyclerAdapter.Holder, position: Int) {
        holder.bind(data, position)
    }

    override fun getItemCount(): Int {
        return if (data == null) 0 else data!!.size
    }

    fun setData(data: List<*>) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class Holder(var root: View) : RecyclerView.ViewHolder(root) {
        fun bind(data: List<*>?, position: Int) {
            bindItemView(root, data, position)
        }
    }

    companion object {
        val TAG = "SimpleRecyclerAdapter"
    }


}
