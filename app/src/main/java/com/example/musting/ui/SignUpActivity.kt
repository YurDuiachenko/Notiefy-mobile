package com.example.musting.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.musting.R
import com.example.musting.ui.stateholders.User

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_activity)

        val nameInput: EditText = findViewById(R.id.nameInput)
        val emailInput: EditText = findViewById(R.id.emailInput)
        val passInput: EditText = findViewById(R.id.passInput)
        val signUpBtn: Button = findViewById(R.id.signUpBtn)

        signUpBtn.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("user", User(emailInput.text.toString(), passInput.text.toString()))
            navigateToSignInActivity(bundle)
        }
    }

    private fun navigateToSignInActivity(bundle: Bundle) {
        val intent = Intent(this, SignInActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}