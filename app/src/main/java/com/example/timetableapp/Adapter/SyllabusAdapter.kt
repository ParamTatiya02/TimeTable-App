package com.example.timetableapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.timetableapp.R

class SyllabusAdapter(
    context: Context,
    private val unitArray : Array<String>,
private val topicArray: Array<String>): BaseAdapter() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return unitArray.size
    }

    override fun getItem(position: Int): Any {
        return unitArray[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder
        if (convertView == null) {
            view = inflater.inflate(R.layout.syllabus_activity_single_item, parent, false)
            holder = ViewHolder()

            //Get the respective Element
            holder.unit = view.findViewById(R.id.tvSyllabusTitle) as TextView
            holder.topic = view.findViewById(R.id.tvSyllabus) as TextView
            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }
        val unit = holder.unit
        val topic = holder.topic

        unit.text = unitArray[position]
        topic.text = topicArray[position]

        return view
    }

    private class ViewHolder {
        lateinit var unit: TextView
        lateinit var topic: TextView
    }
}