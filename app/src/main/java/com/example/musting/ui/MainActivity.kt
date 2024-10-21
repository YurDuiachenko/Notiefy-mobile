package com.example.musting.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.musting.R

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController

    }

    fun navigateOnboardToSignIn() {
        navController.navigate(R.id.action_onboardFragment_to_signInFragment)
    }

    fun navigateSignInToHome() {
        navController.navigate(R.id.action_signinFragment_to_homeFragment)
    }

    fun navigateSignInToSignUp() {
        navController.navigate(R.id.action_signinFragment_to_signupFragment)
    }
}
