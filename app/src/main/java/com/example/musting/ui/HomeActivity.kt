package com.example.musting.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musting.R


class HomeActivity : ComponentActivity() {

    private val examples = listOf(
        Current("BTC", "Bitcoin", 61294.00, 0.92),
        Current("ETH", "Etherium", 2379.74, 1.09),
        Current("BNB", "BNB", 552.30, 1.96),
        Current("HMSTR", "", 0.004667, -2.14)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        val recyclerView = findViewById<RecyclerView>(R.id.currents)

        val data: MutableList<Current> = ArrayList(examples)

        recyclerView.setLayoutManager(LinearLayoutManager(this))
        val adapter = CurrentsViewAdapter(data)
        recyclerView.setAdapter(adapter)
    }
}