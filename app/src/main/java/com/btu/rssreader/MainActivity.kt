package com.btu.rssreader

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var emailInput: EditText
    private lateinit var messageInput: EditText
    private lateinit var sendButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailInput = findViewById(R.id.emailInput)
        messageInput = findViewById(R.id.messageInput)
        sendButton = findViewById(R.id.sendButton)

        // Limit message input to 250 characters and show an error if exceeded
        messageInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null && s.length > 250) {
                    messageInput.error = "Message cannot exceed 250 characters"
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        sendButton.setOnClickListener {
            val email = emailInput.text.toString()
            val message = messageInput.text.toString()

            if (!email.contains("@")) {
                emailInput.error = "Invalid email address"
                return@setOnClickListener
            }
            if (message.length > 250) {
                messageInput.error = "Message cannot exceed 250 characters"
                return@setOnClickListener
            }

            // Forward email and message to SecondActivity
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("email", email)
            intent.putExtra("message", message)
            startActivity(intent)
        }
    }
}
