package com.example.balajitradingcoorperation

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class GetStartedActivity : AppCompatActivity() {

    private lateinit var btnLogout: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)

        // Initialize logout button
        btnLogout = findViewById(R.id.btnLogout)

        btnLogout.setOnClickListener {
            // Clear shared preferences login state
            val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            sharedPreferences.edit().putBoolean("isLoggedIn", false).apply()

            // Sign out from Firebase Auth
            FirebaseAuth.getInstance().signOut()

            // Navigate back to LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Close GetStartedActivity
        }
    }
}
