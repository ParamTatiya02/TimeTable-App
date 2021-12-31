package com.example.timetableapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.timetableapp.R
import com.example.timetableapp.util.LetterImageView

class DayAdapter(
    context: Context,
    private val subjectArray : Array<String>,
    private val timeArray: Array<String>): BaseAdapter() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return subjectArray.size
    }

    override fun getItem(position: Int): Any {
        return subjectArray[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder
        if (convertView == null) {
            view = inflater.inflate(R.layout.day_activity_single_item, parent, false)
            holder = ViewHolder()

            //Get the respective Element
            holder.dayLetter = view.findViewById(R.id.ivLetterDay) as LetterImageView
            holder.subject = view.findViewById(R.id.tvDay) as TextView
            holder.time = view.findViewById(R.id.tvTimeDay) as TextView
            view.tag = holder
        }else{
            view = convertView
            holder = convertView.tag as ViewHolder
        }
        val subject = holder.subject
        val time = holder.time

        subject.text = subjectArray[position]
        time.text = timeArray[position]

        holder.dayLetter.isOval = true
        val firstLetter = subject.text.toString()
        holder.dayLetter.letter = firstLetter[0]

        return view
    }
    private class ViewHolder {
        lateinit var subject: TextView
        lateinit var time: TextView
        lateinit var dayLetter : LetterImageView
    }
}