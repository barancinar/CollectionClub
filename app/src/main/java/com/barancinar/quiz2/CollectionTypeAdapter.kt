package com.barancinar.quiz2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CollectionTypeAdapter(val context: Context, val data: ArrayList<CollectionTypeModel>):BaseAdapter() {
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): CollectionTypeModel {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return data[position].id
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if(convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.collection_item_model, parent, false)
        }

        val item = data[position]
        val imageTypeItem = view!!.findViewById<ImageView>(R.id.imageTypeItem)
        val tvTypeItem = view.findViewById<TextView>(R.id.tvTypeItem)

        imageTypeItem.setImageDrawable(context.getDrawable(item.image))
        tvTypeItem.setText(item.type)

        return view
    }
}