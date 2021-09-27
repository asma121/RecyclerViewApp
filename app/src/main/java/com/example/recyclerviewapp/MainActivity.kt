package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var conlay:ConstraintLayout
    lateinit var personname:EditText
    lateinit var button:Button
    var names = arrayListOf<String>()

    fun addname(){
        var msg=personname.text.toString()
        if (msg.isNotEmpty()){
            names.add(msg)
            personname.text.clear()
            personname.clearFocus()
        }else{
            Snackbar.make(conlay,"Enter name",Snackbar.LENGTH_LONG).show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        conlay=findViewById(R.id.conlay)
        personname=findViewById(R.id.personname)
        button=findViewById(R.id.button)

        button.setOnClickListener(){
           addname()
            val myRv=findViewById<RecyclerView>(R.id.rvMain)
            myRv.adapter=RecyclerViewAdapter(this,names)
            myRv.layoutManager=LinearLayoutManager(this)
        }



    }
}