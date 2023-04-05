package com.example.minor_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recv)
        val item = ArrayList<notes_items>()
        item.add(notes_items(R.drawable.img, "Environmental Science","https://firebasestorage.googleapis.com/v0/b/notes-pdf-minor-project.appspot.com/o/EVS-MG-Module1.pdf?alt=media&token=c018cb63-fbf8-49df-92b3-ddcaf34e688d"))
        item.add(notes_items(R.drawable.img_2, "Engineering Chemistry","https://firebasestorage.googleapis.com/v0/b/notes-pdf-minor-project.appspot.com/o/EngineeringChemistry-Module1.pdf?alt=media&token=efea1eb6-8ab1-4ac0-b2dc-e3d9fd74b84b"))
        item.add(notes_items(R.drawable.img_3, "Data Structures","https://firebasestorage.googleapis.com/v0/b/notes-pdf-minor-project.appspot.com/o/DataStructure-Notes.pdf?alt=media&token=f2e741f4-beb8-4833-8142-5499af5afd9b"))
        item.add(notes_items(R.drawable.img_4, "Database Management System","https://firebasestorage.googleapis.com/v0/b/notes-pdf-minor-project.appspot.com/o/UNIT%201_dbms%20(1).pdf?alt=media&token=2f10a273-3b39-43b6-aa44-54e899f14010"))
        val adapter = notesAdapter(item,this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}