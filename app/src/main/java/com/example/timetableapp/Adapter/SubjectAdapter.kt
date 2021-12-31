package com.example.timetableapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.timetableapp.R
import com.example.timetableapp.util.LetterImageView

class SubjectAdapter(
    context: Context,
    private val data: Array<String>
):BaseAdapter() {

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
            view = inflater.inflate(R.layout.subject_activity_single_item, parent, false)
            holder = ViewHolder()

            //Get the respective Element
            holder.name = view.findViewById(R.id.tvSubject) as TextView
            holder.letter = view.findViewById(R.id.ivLetterSubject) as LetterImageView
            view.tag = holder
        }else{
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val name = holder.name

        //Assign the respective Values
        name.text= data[position]
        holder.letter.isOval = true
        val firstLetter = name.text.toString()
        holder.letter.letter = firstLetter[0]

        return view
    }
    private class ViewHolder {
        lateinit var name: TextView
        lateinit var letter: LetterImageView
    }
}

