package com.example.balajitradingcoorperation

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        // Find the Skip and Next buttons in the layout
        val skipButton: TextView = findViewById(R.id.skipButton)
        val nextButton: TextView = findViewById(R.id.nextButton)

        // Handle Skip button click
        skipButton.setOnClickListener {
            navigateToMainScreen()
        }

        // Handle Next button click
        nextButton.setOnClickListener {
            navigateToNextScreen()
        }
    }

    // Function to navigate to the main screen (MainActivity)
    private fun navigateToMainScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()  // Finish OnboardingActivity so the user can't go back to it
    }

    // Function to navigate to the next onboarding screen (OnboardingPaymentActivity)
    private fun navigateToNextScreen() {
        val intent = Intent(this, OnboardingPaymentActivity::class.java)
        startActivity(intent)
        finish()  // Finish OnboardingActivity so the user can't go back to it
    }
}