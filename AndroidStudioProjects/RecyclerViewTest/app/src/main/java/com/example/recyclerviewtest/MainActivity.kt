package com.example.recyclerviewtest

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclerviewtest.adapter.FruitAdapter
import com.example.recyclerviewtest.adapter.FruitWaterfulAdapter
import com.example.recyclerviewtest.databinding.ActivityMainBinding
import com.example.recyclerviewtest.model.Fruit

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFruits()

        // 瀑布流布局
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerView.layoutManager = layoutManager
        val adapter = FruitWaterfulAdapter(fruitList)
        binding.recyclerView.adapter = adapter

//        // 横向滚动
//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
//        binding.recyclerView.layoutManager = layoutManager
//        val adapter = FruitAdapter(fruitList)
//        binding.recyclerView.adapter = adapter

    }

    private fun initFruits(){
        repeat(20) {
            fruitList.add(Fruit(getRandomLengthString("apple"), R.drawable.ic_launcher_background))
            fruitList.add(Fruit(getRandomLengthString("banana"), R.drawable.ic_launcher_foreground))
        }
    }

    private fun getRandomLengthString(string: String) : String {
        val n = (1..20).random()
        val builder = StringBuilder()
        repeat(n) {
            builder.append(string)
        }
        // Log.d("getRandomLength", "${string}")
        return builder.toString()
    }
}