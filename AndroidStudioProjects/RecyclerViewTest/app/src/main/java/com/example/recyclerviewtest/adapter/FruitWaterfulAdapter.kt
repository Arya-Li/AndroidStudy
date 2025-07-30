package com.example.recyclerviewtest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtest.R
import com.example.recyclerviewtest.model.Fruit

class FruitWaterfulAdapter(val fruitList: List<Fruit>) : RecyclerView.Adapter<FruitWaterfulAdapter.ViewHolder>() {

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val waterfulImg : ImageView = view.findViewById(R.id.waterfulImg)
        val waterfulText : TextView = view.findViewById(R.id.waterfulText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_waterful_item, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.bindingAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val fruit = fruitList[position]
                Toast.makeText(parent.context, "${fruit.name} is clicked" ,Toast.LENGTH_SHORT).show()
            }
        }

        viewHolder.waterfulImg.setOnClickListener {
            val position = viewHolder.bindingAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val fruit = fruitList[position]
                Toast.makeText(parent.context, "${fruit.name} 的图片被点击了", Toast.LENGTH_SHORT).show()
            }
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.waterfulImg.setImageResource(fruit.img)
        holder.waterfulText.text = fruit.name
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }

}