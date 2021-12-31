package com.example.timetableapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.widget.Toolbar
import com.example.timetableapp.Adapter.SubjectAdapter

class SubjectActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var listview: ListView
    companion object{
        lateinit var subjectPreferences: SharedPreferences
        var selectedSubject:String = "DBMS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject)

        setUIView()
        initToolbar()
        val myDataset = resources.getStringArray(R.array.subject)

        val listView = findViewById<ListView>(R.id.lvSubject)
        listView.adapter = SubjectAdapter(this, myDataset)

        listView.setOnItemClickListener { _, _, i, _ ->
            when(i){
                0 -> {
                    subjectPreferences.edit().putString(selectedSubject,"DBMS").apply()
                    startActivity(Intent(this,SyllabusActivity::class.java))
                }
                1 -> {
                    subjectPreferences.edit().putString(selectedSubject,"TOC").apply()
                    startActivity(Intent(this,SyllabusActivity::class.java))
                }
                2 -> {
                    subjectPreferences.edit().putString(selectedSubject,"SP").apply()
                    startActivity(Intent(this,SyllabusActivity::class.java))
                }
                3 -> {
                    subjectPreferences.edit().putString(selectedSubject,"OS").apply()
                    startActivity(Intent(this,SyllabusActivity::class.java))
                }
                4 -> {
                    subjectPreferences.edit().putString(selectedSubject,"CN").apply()
                    startActivity(Intent(this,SyllabusActivity::class.java))
                }
                5 -> {
                    subjectPreferences.edit().putString(selectedSubject,"IoT").apply()
                    startActivity(Intent(this,SyllabusActivity::class.java))
                }
                6 -> {
                    subjectPreferences.edit().putString(selectedSubject,"DS").apply()
                    startActivity(Intent(this,SyllabusActivity::class.java))
                }
                7 -> {
                    subjectPreferences.edit().putString(selectedSubject,"HCI").apply()
                    startActivity(Intent(this,SyllabusActivity::class.java))
                }
                8 -> {
                    subjectPreferences.edit().putString(selectedSubject,"IS").apply()
                    startActivity(Intent(this,SyllabusActivity::class.java))
                }
            }
        }
    }

    private fun setUIView(){
        toolbar = findViewById(R.id.toolbarSubject)
        listview = findViewById(R.id.lvSubject)
        subjectPreferences = getSharedPreferences("MY_SUBJECT", Context.MODE_PRIVATE)
    }

    private fun initToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Subjects"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}