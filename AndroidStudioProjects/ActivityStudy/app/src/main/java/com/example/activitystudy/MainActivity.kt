package com.example.activitystudy


import android.app.ComponentCaller
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.activitystudy.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result -> if (result.resultCode == RESULT_OK){
            // 定义接收到的返回数据处理逻辑
            val message = result.data?.getStringExtra("backMessage")
            Toast.makeText(this, "$message", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            // 显式绑定
//            val intent = Intent(this, IntentOneActivity::class.java)
//            startActivity(intent)
            val intent = Intent("com.example.activitystudy.ACTION_START")
            startActivity(intent)
        }

        binding.btn2.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com"))
            startActivity(intent)
        }

        // 向IntentOneActivity传递信息
        binding.btn3.setOnClickListener {
            // 显式调用
            val intent = Intent(this, IntentOneActivity::class.java)
            intent.putExtra("sendMessage", "fromMainActivity")
            startActivity(intent)
        }

        // 获取IntentOneActivity传递的信息
        // 使用开始Activity
        binding.btn4.setOnClickListener {
            val intent = Intent(this, IntentOneActivity::class.java)
            // 启动一个返回回传信息的activity
            startActivityForResult(intent, 1)
        }

        // 使用Activity Result Launcher获取回传信息
        binding.btn5.setOnClickListener {
            val intent = Intent(this, IntentOneActivity::class.java)
            resultLauncher.launch(intent)
        }
    }

    // 接受下一个activity回传来的信息
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                // val returnData = data?.getStringExtra("backMessage")
                Log.d("requestCodeGet", "backMessage")
                Toast.makeText(this, "已返回", Toast.LENGTH_LONG).show()
            }
        }
    }
}