package com.example.era

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Main: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        // Called when the activity is first created
        // It performs necessary setup such as setting up the layout, UI elements set the layout, and set up the "Reset" button to go to the Dashboard
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        val getStarted: Button = findViewById(R.id.main_reset)

        getStarted.setOnClickListener {
            val intent = Intent(this@Main, DashBoard::class.java)
            startActivity(intent)
            finish()
        }
    }
}