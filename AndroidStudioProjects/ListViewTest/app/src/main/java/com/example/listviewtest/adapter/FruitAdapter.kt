package com.example.listviewtest.adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.listviewtest.R
import com.example.listviewtest.databinding.FruitItemBinding
import com.example.listviewtest.model.Fruit

class FruitAdapter(context: Context, resource : Int, data : List<Fruit>) : ArrayAdapter<Fruit>(context, resource, data) {

    inner class ViewHolder(val fruitImg : ImageView, val fruitText : TextView)


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view : View
        val viewHolder : ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.fruit_item, parent, false)
            val fruitImg : ImageView = view.findViewById(R.id.fruit_img)
            val fruitText : TextView = view.findViewById(R.id.fruit_text)

            viewHolder = ViewHolder(fruitImg, fruitText)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val fruit = getItem(position)
        if (fruit != null) {
            viewHolder.fruitImg.setImageResource(fruit.imgId)
            viewHolder.fruitText.text = fruit.name
        }

        return view

    //        val view = convertView ?: LayoutInflater.from(context).inflate(
//            R.layout.fruit_item,
//            parent,
//            false
//        )
//        val fruitImage = view.findViewById<ImageView>(R.id.fruit_img)
//        val fruitText = view.findViewById<TextView>(R.id.fruit_text)
//
//        // 根据position获取当前fruit对象实例
//        val fruit = getItem(position)
//        if (fruit != null) {
//            fruitImage.setImageResource(fruit.imgId)
//            fruitText.setText(fruit.name)
//        }
//
//        return view
    }

}