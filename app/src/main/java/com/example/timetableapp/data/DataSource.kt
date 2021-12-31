package com.example.timetableapp.data
import com.example.timetableapp.R
import com.example.timetableapp.model.Menu

class DataSource {
    fun loadMenu():List<Menu>{
        return listOf(
            Menu(R.string.title1,R.string.description1,R.string.click,R.drawable.timetable),
            Menu(R.string.title2,R.string.description2,R.string.click,R.drawable.book),
            Menu(R.string.title3,R.string.description3,R.string.click,R.drawable.contact),
            Menu(R.string.title4,R.string.description4,R.string.click,R.drawable.settings)
        )
    }
}