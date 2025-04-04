package com.example.era

import android.os.Bundle
import android.widget.Button
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class Dinner :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        // Called when the activity is first created
        // It performs necessary setup such as setting up the layout, UI elements set the layout, and set up the "Reset" button to go to the Dashboard
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dinner)

        // Theses are the references to the buttons in the Dinner activity layout
        val dhpBtn: Button = findViewById(R.id.dhp_reset)
        val starterBtn: Button = findViewById(R.id.starter_btn)
        val mainBtn: Button = findViewById(R.id.main_btn)
        val dessertBtn: Button = findViewById(R.id.dessert_btn)

        // The Set OnClickListener is for the "dhp_reset" button to take you back to Dashboard activity
        dhpBtn.setOnClickListener {
            val intent = Intent(this@Dinner, DashBoard::class.java)
            startActivity(intent)
            finish()
        }
        // The Set OnClickListener is for the "starter_btn" button to take you back to Starter activity
        starterBtn.setOnClickListener {
            val intent = Intent(this@Dinner, Starter::class.java)
            startActivity(intent)
            finish()
        }
        mainBtn.setOnClickListener {
            val intent = Intent(this@Dinner, Main::class.java)
            startActivity(intent)
            finish()
        }
        dessertBtn.setOnClickListener {
            val intent = Intent(this@Dinner, Dessert::class.java)
            startActivity(intent)
            finish()
        }
    }
}