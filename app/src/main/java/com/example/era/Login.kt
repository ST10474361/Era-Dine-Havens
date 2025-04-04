package com.example.era

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Login :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val getStarted: Button = findViewById(R.id.login_btn)

        getStarted.setOnClickListener {
            val intent = Intent(this@Login, DashBoard::class.java)
            startActivity(intent)
            finish()
        }

        val toolbar: androidx.appcompat.widget.Toolbar? = findViewById(R.id.back1)
        if (toolbar != null) {

            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}




