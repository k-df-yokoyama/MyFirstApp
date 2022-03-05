package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myfirstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var count = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val text1 = binding.text1
        text1.text = "This is sample."
        val button1 = binding.button1
        button1.setOnClickListener {
            text1.text = "count: " + ++count
            Toast.makeText(this, "tapped!", Toast.LENGTH_SHORT).show()
        }
    }

}