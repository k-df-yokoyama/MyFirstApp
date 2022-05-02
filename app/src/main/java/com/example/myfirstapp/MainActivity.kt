package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val data:MutableList<Person> = mutableListOf(
        Person("Taro", "taro@yamada", 36),
        Person("Hanako", "hanako@flower", 25),
        Person("Sachiko", "sachiko@happy", 14)
    )

    fun to_s(ob:Person): Any? = "$ob.name ($ob.mail, $ob.age)"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        text1.text = updateData()
        button1.setOnClickListener {
            val nm =frm_name.text
            val ml = frm_mail.text
            val ag = frm_age.text
            data.add(Person(nm.toString(), ml.toString(), ag.toString().toInt()))
            text1.text = updateData()
        }
    }


    fun updateData():String {
        var people = ""
        for(item in data) {
            people += item.to_s()
            people += "\n"
        }
        return people
    }

}