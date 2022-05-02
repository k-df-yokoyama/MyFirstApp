package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myfirstapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        val myViewModel: MyViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        binding.viewmodel = myViewModel
        binding.text1.text = myViewModel.allText

        button1.setOnClickListener {
            val nm = binding.frmName.text
            val ml = binding.frmMail.text
            val ag = binding.frmAge.text
            myViewModel.add(nm.toString(), ml.toString(), ag.toString().toInt())
            myViewModel.person = Person(nm.toString(), ml.toString(), ag.toString().toInt())
            myViewModel.allText = myViewModel.allByText()
            binding.text1.text = myViewModel.allText
        }
    }
}