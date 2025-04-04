package com.example.era

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class Signup : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var rePasswordEditText: EditText
    private lateinit var signupButton: MaterialButton
    private lateinit var loginTextView: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        nameEditText = findViewById(R.id.name)
        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.e_password)
        rePasswordEditText = findViewById(R.id.re_password)
        signupButton = findViewById(R.id.signup_btn)
        loginTextView = findViewById(R.id.login_a)

        signupButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val rePassword = rePasswordEditText.text.toString()

            // This is to perform signup logic
            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != rePassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            loginTextView.setOnClickListener {
                // This is to redirect to the login page if the user clicks "Already Have An Account Login"
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
                finish()
            }

            val passEditText: EditText = findViewById(R.id.e_password)
            val getStarted: Button = findViewById(R.id.signup_btn)

            getStarted.setOnClickListener {
                val password = passEditText.text.toString()

                //// This is the statement when your password is less than 10 Character
                if (password.length < 10) {
                    Toast.makeText(
                        this,
                        "Password cannot be less than 10 characters.",
                        Toast.LENGTH_LONG
                    ).show()

                } else {

                    val intent = Intent(this@Signup, DashBoard::class.java)
                    startActivity(intent)
                    finish()
                }


                val toolbar: androidx.appcompat.widget.Toolbar? = findViewById(R.id.back)
                if (toolbar != null) {

                    setSupportActionBar(toolbar)
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                    supportActionBar?.setDisplayShowHomeEnabled(true)
                }
            }


            fun onOptionsItemSelected(item: MenuItem): Boolean {
                return when (item.itemId) {
                    android.R.id.home -> {
                        // If the Up button is clicked it will take you to the previous activity
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                        true
                    }

                    else -> super.onOptionsItemSelected(item)
                }
            }
        }
    }
}

















