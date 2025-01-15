package com.example.finalproject_gomez_bislumbre

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyDisasterListAdapter(private val context: Context, private var disasters: List<NaturalDisastersModelClass>) : BaseAdapter() {

    fun updateData(newData: List<NaturalDisastersModelClass>) {
        disasters = newData
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return disasters.size
    }

    override fun getItem(position: Int): Any {
        return disasters[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.custom_disaster_list, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val disaster = getItem(position) as NaturalDisastersModelClass
        holder.typeTextView.text = disaster.disasterType
        holder.detailsTextView.text = disaster.disasterDetails

        return view
    }


    private class ViewHolder(view: View) {
        val typeTextView: TextView = view.findViewById(R.id.textViewDisasterName)
        val detailsTextView: TextView = view.findViewById(R.id.textViewDisasterDetails)
    }


}