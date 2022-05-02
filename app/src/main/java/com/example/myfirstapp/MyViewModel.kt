package com.example.myfirstapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    val data: MutableLiveData<MutableList<Person>> by lazy {
        MutableLiveData<MutableList<Person>>()
    }

    val name: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val mail: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val age: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val allText: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun allByText(): String {
        var res = String()
        for (item in data.value!!) {
            res += item.to_s()
            res += "\n"
        }
        return res
    }

    fun getById(id: Int): Person = data.value!!.get(id)

    fun add(nm: String, ml: String, ag: Int) {
        data.value?.add(Person(nm, ml, ag))
    }

    init {
        data.value = mutableListOf(
            Person("Taro", "taro@yamada", 36),
            Person("Hanako", "hanako@flower", 25),
            Person("Sachiko", "sachiko@happy", 14)
        )
        allText.value = allByText()
        name.value = "name"
        mail.value = "mail@address"
        age.value = "0"
    }
}


class Person(name: String, mail: String, age: Int) {
    var name: String = name
    var mail: String = mail
    var age: Int = age

    fun age_s(): String = age.toString()

    fun to_s(): Any? = "$name ($mail, $age)"
}
