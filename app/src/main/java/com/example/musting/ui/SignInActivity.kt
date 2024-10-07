package com.example.musting.ui

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.example.musting.R

class SignInActivity : ComponentActivity() {

    companion object {
        private const val TAG = "SignInActivity"
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate called")
        setContentView(R.layout.signin_activity)

        val emailInput: EditText = findViewById(R.id.emailInput)
        val passInput: EditText = findViewById(R.id.passInput)
        val logInBtn: Button = findViewById(R.id.logInBtn)
        val signUpBtn: Button = findViewById(R.id.signUpBtn)

        setDefaultInputValues(emailInput, passInput)

        logInBtn.setOnClickListener {
            val email = emailInput.text.toString()
            if (!isValidEmail(email) || passInput.text.isBlank())
                warnUser(logInBtn)
            else if (email == "d.yurok22@mail.ru")
                navigateToHomeActivity()
        }
        signUpBtn.setOnClickListener {
            navigateToSignUpActivity()
        }
    }

    private fun setDefaultInputValues(emailInput: EditText, passInput: EditText) {
        intent.getStringExtra("userData")?.split("\n")?.let {
            emailInput.hint = it[0]
            passInput.hint = it[1]
        }
    }

    private fun warnUser(logInBtn: Button) {
        logInBtn.text = "Creds are invalid. Retype and login."
        logInBtn.setTextColor(Color.parseColor("#A02A38"))
    }

    private fun navigateToHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSignUpActivity() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }

    private fun isValidEmail(email: String): Boolean {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$".toRegex())
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