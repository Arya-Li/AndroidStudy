package com.example.activitylifecycletest

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.activitylifecycletest.databinding.ActivityDialogBinding

class DialogActivity : BaseActivity() {

    private lateinit var binding : ActivityDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 显式当前所在 Activity
        Log.d("location", javaClass.simpleName)

        Log.d("LifeCycle","DialogActivity-onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("LifeCycle", "DialogActivity-onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycle", "DialogActivity-onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycle", "DialogActivity-onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle", "DialogActivity-onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle", "DialogActivity-onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LifeCycle", "DialogActivity-onRestart")
    }

    @SuppressLint("GestureBackNavigation")
    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("username", "lihua")
        setResult(1, intent)
        super.onBackPressed()
    }
}