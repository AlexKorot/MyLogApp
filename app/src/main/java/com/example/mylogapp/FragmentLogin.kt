package com.example.mylogapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.example.mylogapp.FieldValidators.isStringContainNumber
import com.example.mylogapp.FieldValidators.isStringContainSpecialCharacter
import com.example.mylogapp.FieldValidators.isStringLowerAndUpperCase
import com.example.mylogapp.FieldValidators.isValidEmail
import com.example.mylogapp.databinding.FragmentLoginBinding

class FragmentLogin: Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        setupListeners()


        binding.loginButton.setOnClickListener {
            if(isValidate()) {

                val login = binding.email.text.toString()
                val password = binding.password.text.toString()
                val direction =
                    FragmentLoginDirections.actionFragmentLoginToFragmentAccount(login, password)
                findNavController().navigate(direction)

            }
        }
    }
    private fun isValidate(): Boolean = validateEmail() && validatePassword()

    private fun setupListeners() {
        binding.apply {
            email.addTextChangedListener(TextFieldValidation(binding.email))
            password.addTextChangedListener(TextFieldValidation(binding.password))
        }
    }



    private fun validateEmail(): Boolean {
        if (binding.email.text.toString().trim().isEmpty()) {
            binding.email.error = getString(R.string.field_must)
            binding.email.requestFocus()
            return false
        } else if (!isValidEmail(binding.email.text.toString())) {
            binding.email.error = getString(R.string.invalid_email)
            binding.email.requestFocus()
            return false
        }
        return true
    }


    private fun validatePassword(): Boolean {
        if (binding.password.text.toString().trim().isEmpty()) {
            binding.passwordTextInputLayout.error = getString(R.string.required_field)
            binding.password.requestFocus()
            return false
        } else if (binding.password.text.toString().length < 6) {
            binding.passwordTextInputLayout.error = getString(R.string.password_more_6)
            binding.password.requestFocus()
            return false
        } else if (!isStringContainNumber(binding.password.text.toString())) {
            binding.passwordTextInputLayout.error = getString(R.string.required_digit)
            binding.password.requestFocus()
            return false
        } else if (!isStringLowerAndUpperCase(binding.password.text.toString())) {
            binding.passwordTextInputLayout.error =
                getString(R.string.lower_letters)
            binding.password.requestFocus()
            return false
        } else if (!isStringContainSpecialCharacter(binding.password.text.toString())) {
            binding.passwordTextInputLayout.error = getString(R.string.special_charter)
            binding.password.requestFocus()
            return false
        } else {
            binding.passwordTextInputLayout.isErrorEnabled = false
        }
        return true
    }



    inner class TextFieldValidation(private val view: View) : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            when (view.id) {

                R.id.email -> {
                    validateEmail()
                }
                R.id.password -> {
                    validatePassword()
                }

            }
        }
    }
}
