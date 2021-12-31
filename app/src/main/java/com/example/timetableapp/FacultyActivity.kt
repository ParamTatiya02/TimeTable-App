package com.example.timetableapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.widget.Toolbar
import com.example.timetableapp.Adapter.FacultyAdapter

class FacultyActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var listview: ListView
    companion object{
        lateinit var facultyPreferences: SharedPreferences
        var selectedFaculty:String = "0"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faculty)

        setUIView()
        initToolbar()

        val listView = findViewById<ListView>(R.id.lvFaculty)
        listView.adapter = FacultyAdapter(this, resources.getStringArray(R.array.TeacherName),resources.getStringArray(R.array.TeacherQuality))

        listView.setOnItemClickListener { _, _, i, _ ->
            when(i){
                0 -> {
                    facultyPreferences.edit().putInt(selectedFaculty,0).apply()
                    startActivity(Intent(this,FacultyInfoActivity::class.java))
                }
                1 -> {
                    facultyPreferences.edit().putInt(selectedFaculty,1).apply()
                    startActivity(Intent(this,FacultyInfoActivity::class.java))
                }
                2 -> {
                    facultyPreferences.edit().putInt(selectedFaculty,2).apply()
                    startActivity(Intent(this,FacultyInfoActivity::class.java))
                }
                3 -> {
                    facultyPreferences.edit().putInt(selectedFaculty,3).apply()
                    startActivity(Intent(this,FacultyInfoActivity::class.java))
                }
                4 -> {
                    facultyPreferences.edit().putInt(selectedFaculty,4).apply()
                    startActivity(Intent(this,FacultyInfoActivity::class.java))
                }
                else -> {
                    facultyPreferences.edit().putInt(selectedFaculty,5).apply()
                    startActivity(Intent(this,FacultyInfoActivity::class.java))
                }
            }
        }
    }

    private fun setUIView(){
        toolbar = findViewById(R.id.toolbarFaculty)
        listview = findViewById(R.id.lvFaculty)
        facultyPreferences = getSharedPreferences("MY_FACULTY", Context.MODE_PRIVATE)
    }

    private fun initToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Faculty"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}