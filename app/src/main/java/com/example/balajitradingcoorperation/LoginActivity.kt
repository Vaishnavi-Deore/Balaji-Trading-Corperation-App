package com.example.balajitradingcoorperation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvForgotPassword: TextView
    private lateinit var tvSignUp: TextView

    private lateinit var auth: FirebaseAuth // Firebase Auth instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Check login status using shared preferences
        val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        if (isLoggedIn) {
            // If user is already logged in, navigate to main screen
            navigateToMainScreen()
            return // Exit onCreate
        }

        setContentView(R.layout.activity_login)

        // Initialize views
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvForgotPassword = findViewById(R.id.tvForgotPassword)
        tvSignUp = findViewById(R.id.tvSignUp)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Login button click listener
        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // Save login state in shared preferences
                            sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()

                            // Navigate to main screen
                            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                            navigateToMainScreen()
                        } else {
                            // Show login error
                            Toast.makeText(
                                this,
                                "Login failed: ${task.exception?.message}",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
            } else {
                // Show empty field error
                Toast.makeText(this, "Please fill in both email and password", Toast.LENGTH_SHORT).show()
            }
        }

        // Forgot password click listener (optional)
        tvForgotPassword.setOnClickListener {
            // Navigate to ForgotPasswordActivity (implement if needed)
        }

        // Sign up click listener
        tvSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    // Function to navigate to the main screen
    private fun navigateToMainScreen() {
        val intent = Intent(this, GetStartedActivity::class.java)
        startActivity(intent)
        finish() // Close LoginActivity
    }
}
