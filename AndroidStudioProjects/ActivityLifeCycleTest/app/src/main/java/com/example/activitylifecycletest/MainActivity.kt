package com.example.activitylifecycletest

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.activitylifecycletest.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding : ActivityMainBinding
    private val resultLuncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result -> if (result.resultCode == RESULT_OK) {
            val username = result.data?.getStringExtra("username")
            Toast.makeText(this, "Hello, $username", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("testFunction", binding.editTv.text.toString())

        // Log显示信息
        Log.d("LifeCycle", "MainActivity-onCreate")

        // 显式当前所在 Activity
        Log.d("location", javaClass.simpleName)

        // 启动 Normal Activity
        binding.btnNormal.setOnClickListener {
            val intent = Intent(this, NormalActivity::class.java)
            resultLuncher.launch(intent)
        }

        // 启动 Dialog Activity
        binding.btnDialog.setOnClickListener {
            val intent = Intent(this, DialogActivity::class.java)

            if (savedInstanceState != null) {
                intent.putExtras(savedInstanceState)
                Log.d("mainactivity", "Bundle not null")
                Toast.makeText(this, savedInstanceState.getString("name"), Toast.LENGTH_LONG).show()
            } else {
                Log.d("mainactivity", "Bundle null")
            }

            // 和上面判空条件效果等价
            // savedInstanceState?.let { it1 -> intent.putExtras(it1) }


            resultLuncher.launch(intent)
        }

        // 使用companion object传递数据
        binding.useCompanion.setOnClickListener {
            NormalActivity.actionStart(this, "data1", "data2")
        }

    }

    // Activity销毁后保存信息
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        // outState.putString("name", binding.editTv.text.toString())
        outState.apply {
            putString("name", binding.editTv.text.toString())
            putInt("num", 1)
            putBoolean("storeData", true)
        }
        // 父类在后
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d("StoreMessage", "onSaveInstanceState ing")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val storeMessage = savedInstanceState.getString("name")
        binding.tv1.setText(storeMessage)
        Toast.makeText(this, storeMessage, Toast.LENGTH_LONG).show()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LifeCycle", "MainActivity-onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.d("LifeCycle", "MainActivity-onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycle", "MainActivity-onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycle", "MainActivity-onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle", "MainActivity-onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle", "MainActivity-onDestroy")
    }
}