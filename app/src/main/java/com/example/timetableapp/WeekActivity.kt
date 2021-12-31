package com.example.timetableapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.widget.Toolbar
import com.example.timetableapp.Adapter.WeekAdapter

class WeekActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var listview:ListView
    companion object{
        lateinit var sharedPreferences:SharedPreferences
        var selectedDay:String = "Monday"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week)

        setUIView()
        initToolbar()
        val myDataset = resources.getStringArray(R.array.Week)

        val listView = findViewById<ListView>(R.id.lvWeek)
        listView.adapter = WeekAdapter(this, myDataset)

        listView.setOnItemClickListener { _, _, i, _ ->
            when(i){
                0 -> {
                    sharedPreferences.edit().putString(selectedDay,"Monday").apply()
                    startActivity(Intent(this,DayActivity::class.java))
                }
                1 -> {
                    sharedPreferences.edit().putString(selectedDay, "Tuesday").apply()
                    startActivity(Intent(this,DayActivity::class.java))
                }
                2 -> {
                    sharedPreferences.edit().putString(selectedDay, "Wednesday").apply()
                    startActivity(Intent(this,DayActivity::class.java))
                }
                3 -> {
                    sharedPreferences.edit().putString(selectedDay, "Thursday").apply()
                    startActivity(Intent(this,DayActivity::class.java))

                }
                4 -> {
                    sharedPreferences.edit().putString(selectedDay, "Friday").apply()
                    startActivity(Intent(this,DayActivity::class.java))
                }
                else -> {
                    sharedPreferences.edit().putString(selectedDay, "Saturday").apply()
                    startActivity(Intent(this,DayActivity::class.java))
                }
            }
        }

    }

    private fun setUIView(){
        toolbar = findViewById(R.id.toolbarWeek)
        listview = findViewById(R.id.lvWeek)
        sharedPreferences = getSharedPreferences("MY_DAY",Context.MODE_PRIVATE)
    }

    private fun initToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Week Days"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}