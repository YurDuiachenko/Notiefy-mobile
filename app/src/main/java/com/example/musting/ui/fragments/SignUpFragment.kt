package com.example.musting.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.musting.R
import com.example.musting.databinding.FragmentSignupBinding
import com.example.musting.ui.stateholders.User

class SignUpFragment : Fragment(R.layout.fragment_signup) {
    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameInput: EditText = binding.nameInput
        val emailInput: EditText = binding.emailInput
        val passInput: EditText = binding.passInput
        val signUpBtn: Button = binding.signUpBtn

        signUpBtn.setOnClickListener {
            val user = User(
                emailInput.text.toString(),
                passInput.text.toString()
            )

            val action = SignUpFragmentDirections.actionSignupFragmentToSignInFragment(user)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
