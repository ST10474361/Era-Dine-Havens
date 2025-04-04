package com.example.era

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import java.text.SimpleDateFormat
import android.widget.Toast

class DashBoard :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        // This is the references to all the buttons that are in the dashboard
        val breakBtn: Button = findViewById(R.id.break_btn)
        val brkBtn: Button = findViewById(R.id.brk_btn)
        val lunchBtn: Button = findViewById(R.id.lunch_btn)
        val dinnerBtn: Button = findViewById(R.id.dinner_btn)
        val snackBtn: Button = findViewById(R.id.snack_btn)
        val drinkBtn: Button = findViewById(R.id.drink_btn)

        breakBtn.setOnClickListener {
            // This is for the current time.
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            // The menu works on specific time range, if the current time is within the allowed breakfast hours (7:00 - 10:59).
            if ((hour == 7 && minute >= 0) || (hour in 8..10) || (hour == 10 && minute <= 59)){
            val intent = Intent(this@DashBoard, BreakFast::class.java)
            startActivity(intent)
            finish()
            } else {
                // If outside breakfast hours, it will display a message with the current time to suggest to you what is available.
                val currentTimeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
                val currentTime = currentTimeFormat.format(calendar.time)
                Toast.makeText(
                    this,
                    "Breakfast can only be served between 07:00 and 10:59. The current time is $currentTime.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        brkBtn.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            if ((hour == 11 && minute >= 0) || (hour == 12) || (hour == 13 && minute <= 59)) {
            val intent = Intent(this@DashBoard, Brunch::class.java)
            startActivity(intent)
            finish()
            } else {
                val currentTimeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
                val currentTime = currentTimeFormat.format(calendar.time)
                Toast.makeText(
                    this,
                    "Brunch can only be served between 11:00 and 13:59. The current time is $currentTime. Suggest you check our Breakfast",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        lunchBtn.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            if ((hour == 14 && minute >= 0) || (hour in 15..17) || (hour == 17 && minute <= 59)) {
                val intent = Intent(this@DashBoard, Lunch::class.java)
                startActivity(intent)
                finish()
            } else {
                val currentTimeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
                val currentTime = currentTimeFormat.format(calendar.time)
                Toast.makeText(
                    this,
                    "Lunch can only be served between 14:00 and 17:59. The current time is $currentTime. Suggest you check our Brunch menu",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        dinnerBtn.setOnClickListener {
            val intent = Intent(this@DashBoard, Dinner::class.java)
            startActivity(intent)
            finish()

        }

        snackBtn.setOnClickListener {
            // For the Snack, it is always available at any time, it does not have a time range.
            // As the Toast message is "Available".
            // Therefore, we directly navigate to the Snack Menu.
            val intent = Intent(this@DashBoard, Snack::class.java)
            startActivity(intent)
            finish()
        }

        drinkBtn.setOnClickListener {

            val intent = Intent(this@DashBoard, Drinks::class.java)
            startActivity(intent)
            finish()
        }

        }
    }

