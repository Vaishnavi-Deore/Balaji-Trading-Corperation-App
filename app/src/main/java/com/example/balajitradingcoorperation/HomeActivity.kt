package com.example.balajitradingcoorperation

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Click listener for Tank
        val tank = findViewById<LinearLayout>(R.id.tank)
        tank.setOnClickListener {
            Toast.makeText(this, "Tanks section clicked", Toast.LENGTH_SHORT).show()
        }

        // Click listener for Cement
        val cement = findViewById<LinearLayout>(R.id.cement)
        cement.setOnClickListener {
            Toast.makeText(this, "Cement section clicked", Toast.LENGTH_SHORT).show()
        }

        // Click listener for Paints
        val paints = findViewById<LinearLayout>(R.id.paints)
        paints.setOnClickListener {
            Toast.makeText(this, "Paints section clicked", Toast.LENGTH_SHORT).show()
        }

        // Click listener for Pipes
        val pipes = findViewById<LinearLayout>(R.id.pipes)
        pipes.setOnClickListener {
            Toast.makeText(this, "Pipes section clicked", Toast.LENGTH_SHORT).show()
        }

        // Click listener for Tap
        val tap = findViewById<LinearLayout>(R.id.tap)
        tap.setOnClickListener {
            Toast.makeText(this, "Tap section clicked", Toast.LENGTH_SHORT).show()
        }

        // Click listener for Basin
        val basin = findViewById<LinearLayout>(R.id.basin)
        basin.setOnClickListener {
            Toast.makeText(this, "Basins section clicked", Toast.LENGTH_SHORT).show()
        }

        // Click listener for Tiles
        val tiles = findViewById<LinearLayout>(R.id.tiles)
        tiles.setOnClickListener {
            Toast.makeText(this, "Tiles section clicked", Toast.LENGTH_SHORT).show()
        }

        // Click listener for Brushes
        val brushes = findViewById<LinearLayout>(R.id.brushes)
        brushes.setOnClickListener {
            Toast.makeText(this, "Brushes section clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
