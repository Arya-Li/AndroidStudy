package com.example.uibestpractice

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding
import androidx.core.view.updatePadding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uibestpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val msgList = ArrayList<Msg>()
    private var adapter: MsgAdapter? = null
    // private var recyclerView: RecyclerView? = null
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * 设置窗口属性，
         * 禁止系统自动处理系统栏遮挡
         * 将边衬区处理权完全交给开发者
         */
        WindowCompat.setDecorFitsSystemWindows(window, false)



        // 添加窗口边衬区处理
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val ime = insets.getInsets(WindowInsetsCompat.Type.ime())

            view.updatePadding(
                top = systemBars.top,
                bottom = if (ime.bottom > 0) ime.bottom else systemBars.bottom
            )

            insets
        }


        initMsg()

        val layoutManager = LinearLayoutManager(this)
        // recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        binding.recyclerView.layoutManager = layoutManager
        adapter = MsgAdapter(msgList)
        binding.recyclerView.adapter = adapter
        // val send = findViewById<Button>(R.id.sendBtn)
        binding.sendBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.sendBtn -> {
//                val inputText = findViewById<EditText>(R.id.inputText) // 获取输入框
//                // val recyclerView = findViewById<RecyclerView>(R.id.recyclerView) // 获取RecyclerView
//
//                val content = inputText.text.toString()
                val content = binding.inputText.text.toString()
                if (content.isNotEmpty()) {
                    val msg = Msg(content, Msg.TYPE_SEND)
                    msgList.add(msg)
                    adapter?.notifyItemInserted(msgList.size - 1) // 刷新RecyclerView
                    binding.recyclerView.scrollToPosition(msgList.size - 1) // 滚动到最后一行
                    binding.inputText.setText("") // 清空输入框
                    Log.d("onClick",msgList.toString())
                }
            }
        }
    }


    private fun initMsg() {
        val msg1 = Msg("hello", Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("hello guy", Msg.TYPE_SEND)
        msgList.add(msg2)
        val msg3 = Msg("what's your name?", Msg.TYPE_RECEIVED)
        msgList.add(msg3)
        Log.d("initMsg",msgList.toString())
    }
}