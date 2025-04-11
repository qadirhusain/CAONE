package com.example.caone

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)

        val nameEditText = findViewById<EditText>(R.id.et_name)
        val emailEditText = findViewById<EditText>(R.id.et_email)
        val passwordEditText = findViewById<EditText>(R.id.et_password)
        val confirmPasswordEditText = findViewById<EditText>(R.id.et_confirm_password)
        val signupButton = findViewById<Button>(R.id.btn_signup)
        val signInText = findViewById<TextView>(R.id.tv_signin)

        signupButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val confirmPassword = confirmPasswordEditText.text.toString().trim()

            if (validateInputs(name, email, password, confirmPassword)) {
                Toast.makeText(this, "Signup Successful!", Toast.LENGTH_SHORT).show()

                // Move to MainActivity after validation success
                val intent = Intent(this, SignIn::class.java)
                intent.putExtra("USER_NAME", name)
                intent.putExtra("USER_EMAIL", email)
                startActivity(intent)
                finish()
            }
        }

        signInText.setOnClickListener {
            startActivity(Intent(this, SignIn::class.java))
            finish()
        }
    }

    private fun validateInputs(name: String, email: String, password: String, confirmPassword: String): Boolean {
        if (name.isEmpty()) {
            showToast("Please enter your name")
            return false
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showToast("Please enter a valid email address")
            return false
        }

        if (password.isEmpty() || password.length < 6) {
            showToast("Password must be at least 6 characters")
            return false
        }

        if (confirmPassword.isEmpty() || confirmPassword != password) {
            showToast("Passwords do not match")
            return false
        }

        return true
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}