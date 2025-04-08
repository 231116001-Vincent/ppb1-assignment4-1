package com.vharya.assignment4.adapters

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.vharya.assignment4.R

class AdapterImageGrid(
    context: Context,
    images: ArrayList<Int>,
    titles: ArrayList<String>
) : BaseAdapter() {

    private var context = context as Activity
    private var images = images
    private var titles = titles

    override fun getCount(): Int {
        return titles.size
    }

    override fun getItem(position: Int): Any {
        return images[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var row = convertView
        if (row == null) {
            val inflater = context.layoutInflater
            row = inflater.inflate(R.layout.grid_cell, parent, false)
        }

        val imageView = row!!.findViewById<ImageView>(R.id.cell_image)
        val textView = row.findViewById<TextView>(R.id.cell_title)

        imageView.setImageResource(images[position])
        textView.text = titles[position]

        return row
    }

}