package com.example.uistudy

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.uistudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.uisTv1.setOnClickListener(this)
        binding.getEt1.setOnClickListener(this)
        binding.changeImg.setOnClickListener(this)
        binding.changeVis.setOnClickListener(this)
        binding.alertDialog.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            // R.id.uis_tv1 -> Toast.makeText(this, "uis_tv1 Clicked", Toast.LENGTH_LONG).show()
            binding.uisTv1.id -> Toast.makeText(this, "binding", Toast.LENGTH_LONG).show()
            binding.getEt1.id -> {
                Log.d("MainActivity", "getEt1")
                val tv1Content = binding.uisEt1.text.toString()
                Toast.makeText(this, "$tv1Content", Toast.LENGTH_LONG).show()
            }
            binding.changeImg.id -> {
                Log.d("MainActivity", "changeImg")
                binding.iv1.setImageResource(R.drawable.ic_launcher_foreground)
                Toast.makeText(this, "换图成功", Toast.LENGTH_LONG).show()
            }
            binding.changeVis.id -> {
                if (binding.pb1.isVisible) {
                    binding.pb1.visibility = View.INVISIBLE
                } else {
                    binding.pb1.visibility = View.VISIBLE
                }
            }

            binding.alertDialog.id -> {
                AlertDialog.Builder(this).apply {
                    setTitle("alertDialog")
                    setMessage("important message")
                    setCancelable(false)
                    setPositiveButton("确定") { dialog, which -> }
                    setNegativeButton("取消") { dialog, which -> }
                    show()
                }
            }
        }
    }

}