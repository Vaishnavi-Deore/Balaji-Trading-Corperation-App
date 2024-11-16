package com.example.balajitradingcoorperation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShopActivity : AppCompatActivity() {

    private lateinit var addToCartButton: Button
    private lateinit var buyNowButton: Button
    private val cartItems = mutableListOf<String>()  // Example in-memory list to store cart items

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        // Initialize views
        addToCartButton = findViewById(R.id.addToCartButton)

        // Set click listeners for buttons
        addToCartButton.setOnClickListener {
            // Add an item to the cart (this is just a placeholder, you might want to add actual item data)
            cartItems.add("Sample Item")
            Toast.makeText(this, "Item added to cart", Toast.LENGTH_SHORT).show()
        }

        buyNowButton.setOnClickListener {
            // Navigate to CheckoutActivity when "Buy Now" button is clicked
            val intent = Intent(this, CheckoutActivity::class.java)
            intent.putStringArrayListExtra("cartItems", ArrayList(cartItems))  // Pass cart items to Checkout
            startActivity(intent)
        }

        // Setup RecyclerView for similar items (optional)
        // Initialize RecyclerView here if needed
    }
}
