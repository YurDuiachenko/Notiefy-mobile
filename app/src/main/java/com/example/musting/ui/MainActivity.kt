package com.example.musting.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.musting.R
import com.example.musting.ui.fragments.HomeFragment
import com.example.musting.ui.fragments.OnboardFragment
import com.example.musting.ui.fragments.SignInFragment
import com.example.musting.ui.fragments.SignUpFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, OnboardFragment())
                .commit()
        }
    }

    fun navigateToSignIn(bundle: Bundle? = null) {
        val fragment = SignInFragment()
        if (bundle != null) {
            fragment.arguments = bundle
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    fun navigateToSignUp() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SignUpFragment())
            .addToBackStack(null)
            .commit()
    }

    fun navigateToHome() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, HomeFragment())
            .commit()
    }
}
