package com.example.caone

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Show the new splash screen
        setContentView(R.layout.activity_splash_screen)

        // Delay before launching the main activity
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, Signup::class.java))
            finish()
        }, 2000) // 2-second delay
    }
}
