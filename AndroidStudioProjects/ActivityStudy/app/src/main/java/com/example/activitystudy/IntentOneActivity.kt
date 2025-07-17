package com.example.activitystudy

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.activitystudy.databinding.ActivityIntentOneBinding

class IntentOneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntentOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setContentView(R.layout.activity_intent_one)


        binding = ActivityIntentOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d("binding","already have")
        binding.intentBtn.setOnClickListener {
            Toast.makeText(this, "intent1", Toast.LENGTH_LONG).show()
            Log.d("intent", "toast runing")
        }

        val messageFromMainActivity = intent.getStringExtra("sendMessage")
        Log.d("FromMainActivity", "$messageFromMainActivity")
    }

    // 向上一个activity传递信息
    @SuppressLint("GestureBackNavigation")
    override fun onBackPressed() {

        val intent = Intent()
        intent.putExtra("backMessage", "这是返回的信息")
        setResult(RESULT_OK, intent)
        super.onBackPressed()
        finish()
    }
}