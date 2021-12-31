package com.example.timetableapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.widget.Toolbar
import com.example.timetableapp.Adapter.Adapter
import com.example.timetableapp.data.DataSource

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar:Toolbar
    private lateinit var listview:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUIView()
        initToolbar()
        val myDataset = DataSource().loadMenu()

        val listView = findViewById<ListView>(R.id.lvMain)
        listView.adapter = Adapter(this, myDataset)

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                when(position){
                    0 -> {
                        val intent = Intent(this,WeekActivity::class.java)
                        startActivity(intent)
                    }
                    1 -> {
                        val intent = Intent(this,SubjectActivity::class.java)
                        startActivity(intent)
                    }
                    2 -> {
                        val intent = Intent(this,FacultyActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
    }

    private fun setUIView(){
        toolbar = findViewById(R.id.toolbarMain)
        listview = findViewById(R.id.lvMain)
    }

    private fun initToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title = "TimeTable App"
    }
}