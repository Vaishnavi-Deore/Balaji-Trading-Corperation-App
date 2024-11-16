package com.example.balajitradingcoorperation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class GetStartedActivity : AppCompatActivity() {

    // Declare the Get Started button view
    private lateinit var btnGetStarted: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the layout for this activity
        setContentView(R.layout.activity_get_started)

        // Initialize the Get Started button
        btnGetStarted = findViewById(R.id.btnGetStarted)

        // Set an OnClickListener to handle button clicks
        btnGetStarted.setOnClickListener {
            // Create an Intent to navigate to HomepageActivity
            val intent = Intent(this, HomeActivity::class.java)

            // Start the HomepageActivity
            startActivity(intent)

            // Finish the current activity to remove it from the back stack
            finish()
        }
    }
}
