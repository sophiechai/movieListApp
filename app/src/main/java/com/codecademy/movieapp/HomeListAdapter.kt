package com.codecademy.movieapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class HomeListAdapter constructor(context: Context, private val resource: Int, private val itemList: Array<String>?)
    : ArrayAdapter<HomeListAdapter.ItemHolder>(context, resource){

    override fun getCount(): Int {
        return if (this.itemList != null) this.itemList.size else 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView

        val holder: ItemHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, null)
            holder = ItemHolder()
            holder.name = convertView!!.findViewById(R.id.home_textView)
            holder.icon = convertView.findViewById(R.id.image_btn)
            convertView.tag = holder
        } else {
            holder = convertView.tag as ItemHolder
        }

        holder.name!!.text = this.itemList!![position]
        holder.icon!!.setImageResource(R.mipmap.ic_launcher)

        return convertView
    }

    class ItemHolder {
        var name: TextView? = null
        var icon: ImageView? = null
    }

}