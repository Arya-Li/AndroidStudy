package com.example.activitylifecycletest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.activitylifecycletest.databinding.ActivityNormalBinding

class NormalActivity : BaseActivity() {

    private lateinit var binding : ActivityNormalBinding

    // 使用companion object明确参数传递
    companion object {
        fun actionStart(context: Context, data1 : String, data2: String) {
//            val intent = Intent(context, NormalActivity::class.java)
//            intent.putExtra("data1", data1)
//            intent.putExtra("data2", data2)
//            context.startActivity(intent)
            val intent = Intent(context, NormalActivity::class.java).apply {
                putExtra("data1", data1)
                putExtra("data2", data2)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNormalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 将companion object中接收数据赋值给textView
        binding.getCompanionData.setText("data1:" + intent.getStringExtra("data1") + "data2:" + intent.getStringExtra("data2"))

        // 显式当前所在 Activity
        Log.d("location", javaClass.simpleName)

        Log.d("LifeCycle", "NormalActivity-onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("LifeCycle", "NormalActivity-onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycle", "NormalActivity-onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycle", "NormalActivity-onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle", "NormalActivity-onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle", "NormalActivity-onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LifeCycle", "NormalActivity-onRestart")
    }
}