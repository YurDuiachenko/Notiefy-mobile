package com.example.musting.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.musting.R
import com.example.musting.ui.MainActivity
import com.example.musting.ui.stateholders.User

class SignUpFragment : Fragment(R.layout.fragment_signup) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameInput: EditText = view.findViewById(R.id.nameInput)
        val emailInput: EditText = view.findViewById(R.id.emailInput)
        val passInput: EditText = view.findViewById(R.id.passInput)
        val signUpBtn: Button = view.findViewById(R.id.signUpBtn)

        signUpBtn.setOnClickListener {
            val bundle = bundleOf(
                "user" to User(
                    emailInput.text.toString(),
                    passInput.text.toString()
                )
            )
            (activity as MainActivity).navigateToSignIn(bundle)
        }
    }
}
