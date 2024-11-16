package com.example.balajitradingcoorperation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity1 : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash1)

        val skipText: TextView = findViewById(R.id.skipText)
        val getStartedButton: Button = findViewById(R.id.getStartedButton)

        // Navigate to the main activity on button click
        getStartedButton.setOnClickListener {
            navigateToMainActivity()
        }

        // Skip button functionality
        skipText.setOnClickListener {
            navigateToMainActivity()
        }
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent) // Close the splash screen
    }
}
