package com.example.fragmenttest

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.fragmenttest.databinding.ActivityMainBinding
import com.example.fragmenttest.databinding.FragmentLeftBinding
import com.example.fragmenttest.fragment.AnotherFragmentRight
import com.example.fragmenttest.fragment.FragmentLeft
import com.example.fragmenttest.fragment.FragmentRight

class MainActivity : AppCompatActivity(), FragmentLeft.onButtonClickListener {

    private lateinit var binding : ActivityMainBinding
    //private lateinit var fragmentLeftBinding : FragmentLeftBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        fragmentLeftBinding = FragmentLeftBinding.inflate(layoutInflater)
//        fragmentLeftBinding.leftButton.setOnClickListener {
//            Log.d("点击事件", "leftButton被点击了")
//            replaceFragment(AnotherFragmentRight())
//        }
        // 常规传入FragmentRight
        replaceFragment(FragmentRight())

        // 获取Fragment实例并设置监听器
        val leftFragment = supportFragmentManager.findFragmentById(R.id.leftFrag) as? FragmentLeft
        // 监测到点击按钮执行onLeftButtonClick()方法
        leftFragment?.setOnButtonClickListener(this)

    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager  = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.rightFrameLayout, fragment)
        transaction.commit()
    }

    override fun onLeftButtonClick() {
        replaceFragment(AnotherFragmentRight())
    }
}