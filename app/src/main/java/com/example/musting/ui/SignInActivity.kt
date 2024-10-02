package com.example.musting.ui

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.musting.R

class SignInActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin_activity)

        val emailInput: EditText = findViewById(R.id.emailInput)
//        val passInput: EditText = findViewById(R.id.passInput)
//        val logInBtn: Button = findViewById()
//
//        rootView.setOnClickListener {
//            val intent = Intent(this, SignInActivity::class.java)
//            startActivity(intent)
//        }
    }
}