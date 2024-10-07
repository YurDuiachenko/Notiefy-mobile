package com.example.musting.ui.stateholders

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater

import android.view.View

import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.musting.R

class CurrentsViewAdapter(private val data: List<Current>) : RecyclerView.Adapter<CurrentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrentsViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.currents_item_layout, parent, false)
        return CurrentsViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CurrentsViewHolder, position: Int) {
        val item = data[position]
        with(holder) {
            shortName.text = item.shortName
            fullName.text = item.fullName
            cost.text = "$" + item.cost.toString()
            grow.text = when (item.grow >= 0) {
                true -> "+" + item.grow.toString() + "%"
                else -> item.grow.toString() + "%"
            }
            if (item.grow < 0)
                grow.setTextColor(Color.parseColor("#A02A38"))
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}