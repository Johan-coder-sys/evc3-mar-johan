package com.example.evc3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import androidx.core.widget.addTextChangedListener
import com.example.evc3.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tilEmail.editText?.addTextChangedListener{ text->
            binding.btnlogin.isEnabled = validateEmailPassword(text.toString(),binding.tilPassword.editText?.text.toString())
        }
        binding.tilPassword.editText?.addTextChangedListener{ text->
            binding.btnlogin.isEnabled = validateEmailPassword(binding.tilEmail.editText?.text.toString(),text.toString())
        }
        binding.btnlogin.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun validateEmailPassword(email: String, password: String):Boolean{
        val isEmailValid= email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordValid =password.length >=6
        val isIdatEmail = email.equals("ejemplo@idat.edu.pe", ignoreCase = true)

        return isEmailValid && isPasswordValid && isIdatEmail
    }
}