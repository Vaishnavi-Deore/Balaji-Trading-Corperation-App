package com.example.balajitradingcoorperation

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CheckoutActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        // Initialize views
        val profileImage = findViewById<ImageView>(R.id.profileImage)
        val emailAddress = findViewById<EditText>(R.id.emailAddress)
        val name = findViewById<EditText>(R.id.name)  // Changed from password to name
        val postcode = findViewById<EditText>(R.id.postcode)
        val address = findViewById<EditText>(R.id.address)
        val city = findViewById<EditText>(R.id.city)
        val stateSpinner = findViewById<Spinner>(R.id.stateSpinner)

        val saveButton = findViewById<Button>(R.id.saveButton)

        // Populate state spinner with example data
        val states = arrayOf("Select State", "New York", "California", "Texas")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, states)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        stateSpinner.adapter = adapter

        // Profile image click listener (Optional for profile image update)
        profileImage.setOnClickListener {
            Toast.makeText(this, "Profile Image Clicked", Toast.LENGTH_SHORT).show()
            // Code to handle profile image change can be added here
        }

        // Save button click listener
        saveButton.setOnClickListener {
            // Retrieve text from input fields
            val email = emailAddress.text.toString()
            val userName = name.text.toString() // Name entered by the user
            val selectedState = stateSpinner.selectedItem.toString()
            val userPostcode = postcode.text.toString()
            val userCity = city.text.toString()
            val userAddress = address.text.toString()

            // Input validation to check if all fields are filled
            if (email.isEmpty() || userName.isEmpty() || selectedState == "Select State" ||
                userPostcode.isEmpty() || userCity.isEmpty() || userAddress.isEmpty()) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            } else {
                // Handle the saving of user data (e.g., save to database or show confirmation)
                Toast.makeText(this, "Information Saved Successfully", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
