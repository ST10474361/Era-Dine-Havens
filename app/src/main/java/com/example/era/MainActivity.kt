package com.example.era

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        //// This a reference to the "Get Started" button from the layout. so when you click on it, it can take you to the next activity
        val getStarted: Button = findViewById(R.id.start)

        //// This is for the "Get Started" button to work and be pressend
        getStarted.setOnClickListener {
            val intent = Intent(this@MainActivity, Signup::class.java)
            startActivity(intent)
            //// This will Finish the current MainActivity to prevent it going back to the back button
            finish()
        }

    }
}
//Reference for the buttons is from the lessons we did in class. My calculator activity