package com.example.balajitradingcoorperation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OnboardingPaymentActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // This enables edge-to-edge display (optional)
        setContentView(R.layout.activity_onboarding_payment)

        // Safely find the main view and apply insets
        val mainView = findViewById<View>(R.id.main)
        mainView?.let {
            ViewCompat.setOnApplyWindowInsetsListener(it) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

        // Find the Next button and set a click listener to navigate to SplashActivity1
        val nextButton: TextView = findViewById(R.id.nextButton)
        nextButton.setOnClickListener {
            navigateToSplashScreen()
        }
    }

    private fun navigateToSplashScreen() {
        // Start SplashActivity1 when Next is clicked
        val intent = Intent(this, SplashActivity1::class.java)
        startActivity(intent)
        finish() // Optional: Closes OnboardingPaymentActivity after starting SplashActivity1
    }
}