package com.example.musting.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musting.R
import com.example.musting.ui.stateholders.Current
import com.example.musting.ui.stateholders.CurrentsViewAdapter


class HomeFragment : Fragment(R.layout.fragment_home) {
    private val examples = listOf(
        Current("BTC", "Bitcoin", 61294.00, 0.92),
        Current("ETH", "Etherium", 2379.74, 1.09),
        Current("BNB", "BNB", 552.30, 1.96),
        Current("HMSTR", "", 0.004667, -2.14)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.currents)
        val data: MutableList<Current> = ArrayList(examples)

        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = CurrentsViewAdapter(data)
        recyclerView.adapter = adapter
    }
}
