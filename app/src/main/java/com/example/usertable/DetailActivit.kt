package com.example.usertable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

lateinit var name: TextView
lateinit var lastName: TextView
lateinit var age: TextView
class DetailActivit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val intent = intent
        if (intent != null) {
val Name = intent.getStringExtra("name")
            val LastName = intent.getStringExtra("lastName")
            val Age = intent.getIntExtra("age",1)
name = findViewById(R.id.detail_name)
            name.setText(Name)
            lastName = findViewById(R.id.detail_LastName)
            lastName.setText(LastName)
            age = findViewById(R.id.detail_age)
            age.setText(Age.toString())
        }
    }
}