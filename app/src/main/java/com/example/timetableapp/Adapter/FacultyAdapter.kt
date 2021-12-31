package com.example.timetableapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.timetableapp.R
import com.example.timetableapp.util.LetterImageView

class FacultyAdapter(
    context: Context,
    private val NameData: Array<String>,
    private val QualityData: Array<String>
):BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return NameData.size
    }

    override fun getItem(position: Int): Any {
        return NameData[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder
        if (convertView == null) {
            view = inflater.inflate(R.layout.faculty_activity_single_item, parent, false)
            holder = ViewHolder()

            //Get the respective Element
            holder.name = view.findViewById(R.id.tvFaculty) as TextView
            holder.description = view.findViewById(R.id.tvDescriptionFaculty) as TextView
            holder.ivLetterFaculty = view.findViewById(R.id.ivLetterFaculty) as LetterImageView
            view.tag = holder
        }else{
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val name = holder.name
        val description = holder.description

        //Assign the respective Values
        name.text = NameData[position]
        description.text = QualityData[position]

        holder.ivLetterFaculty.isOval = true
        val firstLetter = name.text.toString()
        holder.ivLetterFaculty.letter = firstLetter[0]

        return view
    }
    private class ViewHolder {
        lateinit var name: TextView
        lateinit var description: TextView
        lateinit var ivLetterFaculty: LetterImageView
    }
}