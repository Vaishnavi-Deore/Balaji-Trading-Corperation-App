package com.example.balajitradingcoorperation

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    // Declare view variables
    private lateinit var etUsernameEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnCreateAccount: Button

    // Declare FirebaseAuth instance
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content view to the signup activity layout
        setContentView(R.layout.activity_sign_up)

        // Initialize FirebaseAuth
        mAuth = FirebaseAuth.getInstance()

        // Initialize views from the layout
        etUsernameEmail = findViewById(R.id.etUsernameEmail)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnCreateAccount = findViewById(R.id.btnCreateAccount)

        // Set click listener for the Create Account button
        btnCreateAccount.setOnClickListener {
            // Get input values from the EditText fields
            val usernameEmail = etUsernameEmail.text.toString().trim()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            // Validate input and register user with Firebase Authentication
            if (validateInput(usernameEmail, password, confirmPassword)) {
                registerUser(usernameEmail, password)
            }
        }
    }

    // Function to validate input fields
    private fun validateInput(email: String, password: String, confirmPassword: String): Boolean {
        var isValid = true

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etUsernameEmail.error = "Please enter a valid email"
            isValid = false
        }
        if (password.isEmpty()) {
            etPassword.error = "Please enter a password"
            isValid = false
        }
        if (confirmPassword.isEmpty()) {
            etConfirmPassword.error = "Please confirm your password"
            isValid = false
        }
        if (password != confirmPassword) {
            etConfirmPassword.error = "Passwords do not match"
            isValid = false
        }

        return isValid
    }

    // Function to register a new user with Firebase Authentication
    private fun registerUser(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Registration success, navigate to GetStartedActivity
                    val intent = Intent(this, GetStartedActivity::class.java)
                    startActivity(intent)
                    finish() // Optional: Finish SignUpActivity so it's removed from the back stack
                    Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show()
                } else {
                    // If sign-in fails, display a message to the user.
                    Toast.makeText(this, "Authentication failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
