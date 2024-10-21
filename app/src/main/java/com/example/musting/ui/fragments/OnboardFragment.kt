package com.example.musting.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.musting.R
import com.example.musting.ui.MainActivity

class OnboardFragment : Fragment(R.layout.fragment_onboard) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rootView: View = view.findViewById(R.id.root)
        rootView.setOnClickListener {
            (activity as MainActivity).navigateOnboardToSignIn()
        }
    }
}