package com.example.timetableapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.widget.Toolbar
import com.example.timetableapp.Adapter.SyllabusAdapter

class SyllabusActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var listview: ListView
    private lateinit var unit : Array<String>
    private lateinit var syllabus : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_syllabus)

        setUIView()
        initToolbar()

        val selectedSubject = SubjectActivity.subjectPreferences.getString(SubjectActivity.selectedSubject,"")

        when(selectedSubject){
            "DBMS" -> {
                syllabus = resources.getStringArray(R.array.DBMS)
            }
            "TOC" -> {
                syllabus = resources.getStringArray(R.array.TOC)
            }
            "SP" -> {
                syllabus = resources.getStringArray(R.array.SP)
            }
            "OS" -> {
                syllabus = resources.getStringArray(R.array.OS)
            }
            "CN" -> {
                syllabus = resources.getStringArray(R.array.CN)
            }
            "IoT" -> {
                syllabus = resources.getStringArray(R.array.IoT)
            }
            "DS" -> {
                syllabus = resources.getStringArray(R.array.DS)
            }
            "HCI" -> {
                syllabus = resources.getStringArray(R.array.HCI)
            }
            "IS" -> {
                syllabus = resources.getStringArray(R.array.IS)
            }
        }
        unit = resources.getStringArray(R.array.Units)
        val listView = findViewById<ListView>(R.id.lvSyllabus)
        listView.adapter = SyllabusAdapter(this, unit, syllabus)
    }

    private fun setUIView(){
        toolbar = findViewById(R.id.toolbarSyllabus)
        listview = findViewById(R.id.lvSyllabus)
    }

    private fun initToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title = SubjectActivity.subjectPreferences.getString(SubjectActivity.selectedSubject,"")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
