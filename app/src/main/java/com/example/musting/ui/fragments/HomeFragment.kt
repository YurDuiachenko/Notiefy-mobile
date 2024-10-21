package com.example.musting.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musting.databinding.FragmentHomeBinding
import com.example.musting.ui.stateholders.Current
import com.example.musting.ui.stateholders.CurrentsViewAdapter

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val examples = listOf(
        Current("BTC", "Bitcoin", 61294.00, 0.92),
        Current("ETH", "Etherium", 2379.74, 1.09),
        Current("BNB", "BNB", 552.30, 1.96),
        Current("HMSTR", "", 0.004667, -2.14)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data: MutableList<Current> = ArrayList(examples)
        val adapter = CurrentsViewAdapter(data)

        binding.currents.apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
