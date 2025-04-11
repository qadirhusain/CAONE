package com.example.caone

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val emailEditText = findViewById<EditText>(R.id.et_signin_email)
        val passwordEditText = findViewById<EditText>(R.id.et_signin_password)
        val signInButton = findViewById<Button>(R.id.btn_signin)
        val signupText = findViewById<TextView>(R.id.tv_signup)

        // Handle SignIn Button Click
        signInButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (validateInputs(email, password)) {
                Toast.makeText(this, "SignIn Successful!", Toast.LENGTH_SHORT).show()

                // Move to MainActivity
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("USER_EMAIL", email)
                startActivity(intent)
                finish()
            }
        }

        // Navigate to Signup Activity
        signupText.setOnClickListener {
            startActivity(Intent(this, Signup::class.java))
            finish()
        }
    }

    private fun validateInputs(email: String, password: String): Boolean {
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showToast("Please enter a valid email address")
            return false
        }

        if (password.isEmpty() || password.length < 6) {
            showToast("Password must be at least 6 characters")
            return false
        }

        return true
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
