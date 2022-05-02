package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myViewModel:MyViewModel = ViewModelProvider(this)
            .get(MyViewModel::class.java)
        setContentView(R.layout.activity_main)


        text1.text = updateData(myViewModel)
        button1.setOnClickListener {
            val nm =frm_name.text
            val ml = frm_mail.text
            val ag = frm_age.text
            myViewModel.add(nm.toString(), ml.toString(), ag.toString().toInt())
            text1.text = updateData(myViewModel)
        }
    }


    fun updateData(vm:MyViewModel):String {
        val data = vm.getAll()
        var people = ""
        for(item in data) {
            people += item.to_s()
            people += "\n"
        }
        return people
    }

}