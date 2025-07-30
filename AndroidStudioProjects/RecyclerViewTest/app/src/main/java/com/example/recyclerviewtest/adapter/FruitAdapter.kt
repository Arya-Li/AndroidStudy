package com.example.recyclerviewtest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtest.R
import com.example.recyclerviewtest.model.Fruit

class FruitAdapter(val fruitList : List<Fruit>) : RecyclerView.Adapter<FruitAdapter.ViewHolder>() {

    // 1
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitImage : ImageView = view.findViewById(R.id.fruitImg)
        val fruitName : TextView = view.findViewById(R.id.fruitName)
    }

    // 2
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
        return ViewHolder(view)
    }

    // 3
    override fun getItemCount(): Int {
        return fruitList.size
    }

    // 4
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitImage.setImageResource(fruit.img)
        holder.fruitName.text = fruit.name
    }
}