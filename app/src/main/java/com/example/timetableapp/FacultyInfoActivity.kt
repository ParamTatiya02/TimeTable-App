package com.example.timetableapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import de.hdodenhof.circleimageview.CircleImageView

class FacultyInfoActivity : AppCompatActivity() {

    private lateinit var facultyImage : CircleImageView
    private lateinit var toolbar: Toolbar
    private lateinit var name: TextView
    private lateinit var phone: TextView
    private lateinit var email: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faculty_info)

        setUIView()
        initToolbar()

        val selectedFaculty = FacultyActivity.facultyPreferences.getInt(FacultyActivity.selectedFaculty,0)
        val facultyNames:Array<String> = resources.getStringArray(R.array.TeacherName)
        val facultyArray = intArrayOf(R.array.Shaikh, R.array.Khan, R.array.Wagh, R.array.Pansare, R.array.Wahul, R.array.Khonde)
        val facultyInfo = resources.getStringArray(facultyArray[selectedFaculty])
        phone.text = facultyInfo[0]
        email.text = facultyInfo[1]
        name.text = facultyNames[selectedFaculty]

    }
    private fun setUIView(){
        toolbar = findViewById(R.id.toolbarFacultyInfo)
        facultyImage = findViewById(R.id.cvFaculty)
        name = findViewById(R.id.tvFacultyName)
        phone = findViewById(R.id.tvFacultyPhone)
        email = findViewById(R.id.tvFacultyEmail)
    }

    private fun initToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Faculty Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}

