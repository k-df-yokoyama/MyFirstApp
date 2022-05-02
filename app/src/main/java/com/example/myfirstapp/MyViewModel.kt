package com.example.myfirstapp

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel(){
    val data = ObservableArrayList<Person>().apply {
        add(Person("Taro", "taro@yamada", 36))
        add(Person("Hanako", "hanako@flower", 25))
        add(Person("Sachiko", "sachiko@happy", 14))
    }

    val person = ObservableField<Person>()

    var allText = ObservableField<String>()

    fun allbyText(): String {
        var res = ""
        for (item in data) {
            res += item.to_s()
            res += "\n"
        }
        return res
    }

    fun getById(id:Int):Person = data[id]

    fun add(name:String, mail:String, age:Int) {
        data.add(Person(name, mail, age))
    }
    fun add(person:Person) {
        data.add(person)
    }

    init {
        allText.set((allbyText()))
        person.set(Person("", "", 0))
    }
}


class Person(name:String, mail:String, age:Int) {
    var name = ObservableField<String>()
    var mail = ObservableField<String>()
    var age = ObservableField<String>()

    init {
        this.name.set(name)
        this.mail.set(mail)
        this.age.set(age.toString())
    }

    fun to_s(): String = "${name.get()} (${mail.get()}, ${age.get()})"
}
