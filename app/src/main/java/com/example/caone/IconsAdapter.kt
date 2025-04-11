package com.example.caone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class IconsAdapter(private val iconList: List<IconItem>) :
    RecyclerView.Adapter<IconsAdapter.IconViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IconViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_icon, parent, false)
        return IconViewHolder(view)
    }

    override fun onBindViewHolder(holder: IconViewHolder, position: Int) {
        val iconItem = iconList[position]
        holder.iconImage.setImageResource(iconItem.imageResId)
        holder.iconTitle.text = iconItem.title
    }

    override fun getItemCount(): Int = iconList.size

    class IconViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iconImage: ImageView = view.findViewById(R.id.iv_icon)
        val iconTitle: TextView = view.findViewById(R.id.tv_icon_title)
    }
}
