package com.example.usertable

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private lateinit var recyclerView: RecyclerView
private lateinit var manager: RecyclerView.LayoutManager
private lateinit var myAdapter: RecyclerView.Adapter<*>
var selectedPosition = -1
lateinit var nameInput:EditText
lateinit var lastNameInput:EditText
lateinit var ageInput:EditText
lateinit var seeUserbtn:Button
lateinit var  deleteuserbtn:Button
lateinit var updatebtn:Button
class MainActivity : AppCompatActivity() , MyAdapter.OnItemClickListener{

    var values : ArrayList<User> = arrayListOf<User>( User("Mouhamed" , "Amine", 22), User("Amel" , "Riahi", 20) , User("Mouhamed" , "Amine", 22), User("Mouhamed" , "Amine", 22))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = LinearLayoutManager(this)
        myAdapter = MyAdapter(values,this)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerview).apply {
            layoutManager = manager
            adapter = myAdapter
    }

       seeUserbtn = findViewById(R.id.seeUserbtn)
       seeUserbtn.setOnClickListener { seeUser() ;  }
        deleteuserbtn = findViewById(R.id.deleteUserbtn) ;
deleteuserbtn.setOnClickListener { deleteUser() }
        updatebtn =findViewById(R.id.addUserbtn)
        updatebtn.setOnClickListener { AddUserDialogue() }
    }



    override fun onItemClick(position: Int) {

selectedPosition = position ;
        myAdapter.notifyItemChanged(position)
    }


    fun addUser()
    {   nameInput = findViewById(R.id.nameinput)
        lastNameInput = findViewById(R.id.lastNameinput)
        ageInput = findViewById(R.id.ageinput)
        var user = User(nameInput.getText().toString() , lastNameInput.getText().toString() ,ageInput.getText().toString().toInt())
        values.add(user)
    }
    fun seeUser(){
        var user:User = values[selectedPosition] ;
        val intent = Intent(this, DetailActivit::class.java)
        intent.putExtra("name" , user.name)
        intent.putExtra("lastName", user.lastName)
        intent.putExtra("age",user.age)
        startActivity(intent)

    }

    fun AddUserDialogue() {

        val builder = AlertDialog.Builder(this)

        val dialogview = layoutInflater.inflate(R.layout.dialog_form , null)


 builder.setPositiveButton("cancle",{ dialogin: DialogInterface, i:Int->addUser() })
        builder.setNegativeButton("Add",{ dialogin: DialogInterface, i:Int->})
        builder.setView(dialogview)
       builder.show()
    }

    fun deleteUser() {
        values.removeAt(selectedPosition);



    }


}