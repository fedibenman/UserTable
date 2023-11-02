package com.example.usertable

class User {

        lateinit var name:String
        lateinit var lastName:String
        var age:Int = 0

        constructor(name: String, lastName: String, age: Int) {
                this.name = name
                this.lastName = lastName
                this.age = age
        }
}