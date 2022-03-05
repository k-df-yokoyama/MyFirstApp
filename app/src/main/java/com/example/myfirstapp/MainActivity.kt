package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text1.text = "This is sample."
        button1.setOnClickListener {
            text1.text = "count: " + ++count
            Toast.makeText(this, "tapped!", Toast.LENGTH_SHORT).show()
        }
    }

}