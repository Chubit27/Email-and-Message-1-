package com.btu.rssreader

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var emailDisplay: TextView
    private lateinit var messageDisplay: EditText
    private lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        emailDisplay = findViewById(R.id.emailDisplay)
        messageDisplay = findViewById(R.id.messageDisplay)
        clearButton = findViewById(R.id.clearButton)

        // Retrieve data passed from MainActivity
        val email = intent.getStringExtra("email")
        val message = intent.getStringExtra("message")

        // Display the email and message
        emailDisplay.text = email
        messageDisplay.setText(message)

        // Clear email and message when the Clear button is clicked
        clearButton.setOnClickListener {
            emailDisplay.text = ""
            messageDisplay.setText("")
        }
    }
}
