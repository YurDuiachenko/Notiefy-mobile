package com.example.musting.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.musting.R

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity)

        val nameInput: EditText = findViewById(R.id.nameInput)
        val emailInput: EditText = findViewById(R.id.emailInput)
        val passInput: EditText = findViewById(R.id.passInput)
        val signUpBtn: Button = findViewById(R.id.signUpBtn)

        signUpBtn.setOnClickListener {
            navigateToSignInActivity("${emailInput.text}\n${passInput.text}")
        }
    }

    private fun navigateToSignInActivity(bundle: String) {
        val intent = Intent(this, SignInActivity::class.java)
        intent.putExtra("userData", bundle)
        startActivity(intent)
    }
}