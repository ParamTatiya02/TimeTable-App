package com.example.timetableapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.widget.Toolbar
import com.example.timetableapp.Adapter.DayAdapter

class DayActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var listview: ListView
    private lateinit var preferredDay : Array<String>
    private lateinit var preferredTime : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day)

        setUIView()
        initToolbar()

        val selectedDay = WeekActivity.sharedPreferences.getString(WeekActivity.selectedDay,"")

        when(selectedDay){
            "Monday" -> {
                preferredDay = resources.getStringArray(R.array.Monday)
                preferredTime = resources.getStringArray(R.array.time1)
            }
            "Tuesday" -> {
                preferredDay = resources.getStringArray(R.array.Tuesday)
                preferredTime = resources.getStringArray(R.array.time2)
            }
            "Wednesday" -> {
                preferredDay = resources.getStringArray(R.array.Wednesday)
                preferredTime = resources.getStringArray(R.array.time3)
            }
            "Thursday" -> {
                preferredDay = resources.getStringArray(R.array.Thursday)
                preferredTime = resources.getStringArray(R.array.time4)
            }
            "Friday" -> {
                preferredDay = resources.getStringArray(R.array.Friday)
                preferredTime = resources.getStringArray(R.array.time5)
            }
            "Saturday" -> {
                preferredDay = resources.getStringArray(R.array.Saturday)
                preferredTime = resources.getStringArray(R.array.time6)
            }
        }

        val listView = findViewById<ListView>(R.id.lvDay)
        listView.adapter = DayAdapter(this, preferredDay, preferredTime)
    }

    private fun setUIView(){
        toolbar = findViewById(R.id.toolbarDay)
        listview = findViewById(R.id.lvDay)
    }

    private fun initToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title = WeekActivity.sharedPreferences.getString(WeekActivity.selectedDay,null)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
