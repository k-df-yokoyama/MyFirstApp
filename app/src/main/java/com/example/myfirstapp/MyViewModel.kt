package com.example.myfirstapp

import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel(){
    private val data:MutableList<Person> = mutableListOf(
        Person("Taro", "taro@yamada", 36),
        Person("Hanako", "hanako@flower", 25),
        Person("Sachiko", "sachiko@happy", 14)
    )


    fun getAll():List<Person> = data


    fun getById(id:Int):Person = data[id]


    fun add(name:String, mail:String, age:Int) {
        data.add(Person(name, mail, age))
    }
}


class Person(name:String, mail:String, age:Int) {
    var name:String = name
    var mail:String = mail
    var age:Int = age


    fun to_s(): Any? = "$name ($mail, $age)"
}
