package com.example.balajitradingcoorperation
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Checkout1Activity : AppCompatActivity() {

    private lateinit var backButton: ImageView
    private lateinit var editAddress: ImageView
    private lateinit var addressTextView: TextView
    private lateinit var shoppingListRecyclerView: RecyclerView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        // Initialize views
        backButton = findViewById(R.id.backButton)
        editAddress = findViewById(R.id.editAddress)
        addressTextView = findViewById(R.id.address)


        // Set up back button
        backButton.setOnClickListener {
            onBackPressed()
        }

        // Set up edit address button
        editAddress.setOnClickListener {
            // Logic for editing address (e.g., open address edit screen)
        }


    }


    }
