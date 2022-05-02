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
        binding.person = myViewModel.person.get()

        button1.setOnClickListener {
            myViewModel.add(
                frm_name.text.toString(),
                frm_mail.text.toString(),
                frm_age.text.toString().toInt()
            )
            myViewModel.person!!.get()!!.name.set("name")
            myViewModel.person!!.get()!!.mail.set("mail@address")
            myViewModel.person!!.get()!!.age.set("0")
            myViewModel.allText.set(myViewModel.allbyText())
        }
    }
}