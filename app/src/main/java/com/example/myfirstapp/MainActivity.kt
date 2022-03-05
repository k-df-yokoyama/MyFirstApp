package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text1 = findViewById<TextView>(R.id.text1)
        text1.text = "This is sample."
        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            text1.text = "count: " + ++count
            Toast.makeText(this, "tapped!", Toast.LENGTH_SHORT).show()
        }
    }

}