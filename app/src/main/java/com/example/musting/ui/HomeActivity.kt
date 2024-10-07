package com.example.musting.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musting.R
import com.example.musting.ui.stateholders.Current
import com.example.musting.ui.stateholders.CurrentsViewAdapter


class HomeActivity : ComponentActivity() {

    companion object {
        private const val TAG = "HomeActivity"
    }

    private val examples = listOf(
        Current("BTC", "Bitcoin", 61294.00, 0.92),
        Current("ETH", "Etherium", 2379.74, 1.09),
        Current("BNB", "BNB", 552.30, 1.96),
        Current("HMSTR", "", 0.004667, -2.14)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate called")
        setContentView(R.layout.home_activity)

        val recyclerView = findViewById<RecyclerView>(R.id.currents)

        val data: MutableList<Current> = ArrayList(examples)

        recyclerView.setLayoutManager(LinearLayoutManager(this))
        val adapter = CurrentsViewAdapter(data)
        recyclerView.setAdapter(adapter)
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy called")
    }
}