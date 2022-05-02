package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
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
        val nameObserver = Observer<String> { newName ->
            frm_name.setText(newName, TextView.BufferType.NORMAL)
        }
        myViewModel.name.observe(this, nameObserver)

        val mailObserver = Observer<String> { newMail ->
            frm_mail.setText(newMail, TextView.BufferType.NORMAL)
        }
        myViewModel.mail.observe(this, mailObserver)

        val ageObserver = Observer<String> { newAge ->
            frm_age.setText(newAge, TextView.BufferType.NORMAL)
        }
        myViewModel.age.observe(this, ageObserver)

        val allObserver = Observer<String> { newAll ->
            text1.setText(newAll, TextView.BufferType.NORMAL)
        }
        myViewModel.allText.observe(this, allObserver)

        button1.setOnClickListener {
            myViewModel.add(
                frm_name.text.toString(),
                frm_mail.text.toString(),
                frm_age.text.toString().toInt()
            )
            myViewModel.name.value = ""
            myViewModel.mail.value = ""
            myViewModel.age.value = "0"
            myViewModel.allText.value = myViewModel.allByText()
        }
    }
}