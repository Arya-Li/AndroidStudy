package com.example.listviewtest

import com.example.listviewtest.R
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.listviewtest.adapter.FruitAdapter
import com.example.listviewtest.databinding.ActivityMainBinding
import com.example.listviewtest.model.Fruit

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    // private val data = listOf("1", "2", "3", "4", "5", "1", "2", "3", "4", "5", "1", "2", "3", "4", "5", "1", "2", "3", "4", "5")

    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFruits()

//        val adapter = ArrayAdapter<String>(this, R.layout.simple_list_item_1, data)
//        binding.lv1.adapter = adapter
        val adapter = FruitAdapter(this, R.layout.fruit_item, fruitList)
        binding.lv1.adapter = adapter

        binding.lv1.setOnItemClickListener { parent, view, position, id ->
            val fruit = fruitList[position]
            if (fruit != null) {
                Toast.makeText(this, "${fruit.name}被点击了", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun initFruits() {
        repeat(10){
            fruitList.add(Fruit("apple", R.drawable.ic_launcher_background))
            fruitList.add(Fruit("banana", R.drawable.ic_launcher_foreground))
            fruitList.add(Fruit("pear", R.drawable.ic_launcher_background))
        }
    }
}