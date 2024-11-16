package com.example.balajitradingcoorperation

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Find the notification icon view in the layout
        val notificationIcon: ImageView = findViewById(R.id.notificationIcon)

        // Set an onClickListener to navigate to ShopActivity
        notificationIcon.setOnClickListener {
            // Start ShopActivity when the notification icon is clicked
            startActivity(Intent(this, ShopActivity::class.java))
        }

        // Find the profile photo view in the layout
        val profilePhoto: ImageView = findViewById(R.id.profilePhoto)

        // Set an onClickListener to navigate to CheckoutActivity
        profilePhoto.setOnClickListener {
            // Start CheckoutActivity when the profile photo is clicked
            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
        }
    }
}
