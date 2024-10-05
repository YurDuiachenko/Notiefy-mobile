package com.example.musting.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musting.R

class CurrentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var shortName: TextView
    var fullName: TextView
    var cost: TextView
    var grow: TextView

    init {
        shortName = itemView.findViewById(R.id.shortName)
        fullName = itemView.findViewById(R.id.fullName)
        cost = itemView.findViewById(R.id.cost)
        grow = itemView.findViewById(R.id.grow)
    }
}