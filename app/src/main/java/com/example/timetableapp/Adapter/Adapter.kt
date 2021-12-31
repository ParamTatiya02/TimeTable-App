package com.example.timetableapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.timetableapp.R
import com.example.timetableapp.model.Menu

class Adapter(
    private val context: Context,
    private val data: List<Menu>):BaseAdapter() {

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
            view = inflater.inflate(R.layout.main_activity_single_item, parent, false)
            holder = ViewHolder()

            //Get the respective Element
            holder.title = view.findViewById(R.id.tvMain) as TextView
            holder.description = view.findViewById(R.id.tvDescription) as TextView
            holder.click = view.findViewById(R.id.tvClick) as TextView
            holder.image = view.findViewById(R.id.ivMain) as ImageView
            view.tag = holder
        }else{
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val title = holder.title
        val description = holder.description
        val click = holder.click
        val image = holder.image

        //Assign the respective Values
        val menu = getItem(position) as Menu
        title.text = context.resources.getString(menu.title)
        description.text = context.resources.getString(menu.description)
        click.text = context.resources.getString(menu.click)
        image.setImageResource(menu.image)

        return view
    }
    private class ViewHolder {
        lateinit var title: TextView
        lateinit var description: TextView
        lateinit var click: TextView
        lateinit var image: ImageView
    }
}
