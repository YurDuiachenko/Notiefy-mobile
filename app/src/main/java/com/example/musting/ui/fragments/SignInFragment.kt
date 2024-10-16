package com.example.musting.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.musting.R
import com.example.musting.ui.MainActivity
import com.example.musting.ui.stateholders.User

class SignInFragment : Fragment(R.layout.fragment_signin) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val emailInput: EditText = view.findViewById(R.id.emailInput)
        val passInput: EditText = view.findViewById(R.id.passInput)
        val logInBtn: Button = view.findViewById(R.id.logInBtn)
        val signUpBtn: Button = view.findViewById(R.id.signUpBtn)

        setDefaultInputValues(emailInput, passInput)

        logInBtn.setOnClickListener {
            val email = emailInput.text.toString()
            if (!isValidEmail(email) || passInput.text.isBlank()) {
                warnUser(logInBtn)
            } else if (email == "d.yurok22@mail.ru") {
                (activity as MainActivity).navigateToHome()
            }
        }

        signUpBtn.setOnClickListener {
            (activity as MainActivity).navigateToSignUp()
        }
    }

    private fun setDefaultInputValues(emailInput: EditText, passInput: EditText) {
        arguments?.let {
            val user = it.getSerializable("user") as? User
            user?.let {
                emailInput.setText(user.email)
                passInput.setText(user.pass)
            }
        }
    }

    private fun warnUser(logInBtn: Button) {
        logInBtn.text = "Creds are invalid. Retype and login."
        logInBtn.setTextColor(Color.parseColor("#A02A38"))
    }

    private fun isValidEmail(email: String): Boolean {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$".toRegex())
    }
}
