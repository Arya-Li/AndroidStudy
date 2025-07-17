package com.example.activitylifecycletest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("which Activity", javaClass.simpleName)
        // 每一个继承BaseActivity的Activity在创建时都加入Activity列表
        ActivityCollector.addActivity(this)
    }

    // 每一个继承BaseActivity的Activity在销毁时都从列表移除
    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }
}