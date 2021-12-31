package com.example.timetableapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.timetableapp.R
import com.example.timetableapp.util.LetterImageView

class WeekAdapter(
    context: Context,
    private val data: Array<String>): BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder
        if (convertView == null) {
            view = inflater.inflate(R.layout.week_activity_single_item, parent, false)
            holder = ViewHolder()

            //Get the respective Element
            holder.ivLogo = view.findViewById(R.id.ivLetter) as LetterImageView
            holder.weekday = view.findViewById(R.id.tvWeek) as TextView
            view.tag = holder
        }else{
            view = convertView
            holder = convertView.tag as ViewHolder
        }
        val weekday = holder.weekday

        weekday.text = data[position]
        holder.ivLogo.isOval = true
        val firstLetter = weekday.text.toString()
        holder.ivLogo.letter = firstLetter[0]

        return view
    }
    private class ViewHolder {
        lateinit var weekday: TextView
        lateinit var ivLogo: LetterImageView
    }
}