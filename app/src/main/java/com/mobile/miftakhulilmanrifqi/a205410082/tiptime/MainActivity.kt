package com.mobile.miftakhulilmanrifqi.a205410082.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.mobile.miftakhulilmanrifqi.a205410082.tiptime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set an error if the password is less than 8 characters.
        binding.nextButton.setOnClickListener({
            if (!isPasswordValid(binding.passwordEditText.text!!)) {
                binding.passwordTextInput.error  = getString( R.string.shr_error_password)
            } else {
                // Clear the error.
                binding.passwordTextInput.error = null
            }
        })

        // Clear the error once more than 8 characters are typed.
        binding.passwordEditText.setOnKeyListener({ _, _, _ ->
            if (isPasswordValid(binding.passwordEditText.text!!)) {
                // Clear the error.
                binding.passwordTextInput.error = null
            }
            false
        })

        binding.cancelButton.setOnClickListener({
            binding.passwordEditText.text = null
        })
    }

    private fun isPasswordValid(text: Editable?): Boolean {
        return text != null && text.length >= 8
    }
}
