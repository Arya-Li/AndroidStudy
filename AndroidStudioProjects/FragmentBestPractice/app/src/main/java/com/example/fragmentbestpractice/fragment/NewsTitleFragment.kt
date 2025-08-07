package com.example.fragmentbestpractice.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentbestpractice.NewsContentActivity
import com.example.fragmentbestpractice.R
import com.example.fragmentbestpractice.databinding.NewsTitleFragBinding
import com.example.fragmentbestpractice.model.News

class NewsTitleFragment :Fragment() {

    // 判断是否为双页
    private var isTwoPane = false

    private var _binding: NewsTitleFragBinding? = null
    private val binding get() = _binding!!


    inner class NewsAdapter(val newsList: List<News>): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val newsTitle : TextView = view.findViewById(R.id.newsTitle)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
            val holder = ViewHolder(view)
            Log.d("NewsTitleFragment","onCreateViewHolder")
            holder.itemView.setOnClickListener {
                val news = newsList[holder.adapterPosition]
                // isTwoPane = true
                if (isTwoPane) {
                    Log.d("twoPane", "onCreateViewHolder")
                    // 双页模式，刷新NewsContentFragment中内容
                    val fragment = activity?.supportFragmentManager?.findFragmentById(R.id.newsContentFrag) as? NewsContentFragment
                    fragment?.refresh(news.title, news.content)
                } else {
                    Log.d("onePane","onCreateViewHolder")
                    NewsContentActivity.actionStart(parent.context, news.title, news.content)
                }
            }
            return holder
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val news = newsList[position]
            holder.newsTitle.text = news.title
        }

        override fun getItemCount(): Int {
            return newsList.size
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = NewsTitleFragBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("NewsTitleFragment", "onViewCreated executed")
        isTwoPane = resources.getBoolean(R.bool.is_two_pane)
        // isTwoPane = activity?.findViewById<View>(R.id.newsContentLayout) != null
        Log.d("NewsTitleFragment", "isTwoPane: $isTwoPane")

        val layoutManager = LinearLayoutManager(requireContext())
        val adapter = NewsAdapter(getNews())

        // 获取RecyclerView实例
        binding.newsTitleRecyclerView.layoutManager = layoutManager
        binding.newsTitleRecyclerView.adapter = adapter
    }

    private fun getNews() : List<News> {
        Log.d("NewsTitleFragment", "getNews Start")
        val newsList = ArrayList<News>()
        for (i in 1 .. 50) {
            val news = News("This is news title ${i}", getRandomLengthString("This is news content ${i}"))
            newsList.add(news)
        }
        Log.d("NewsTitleFragment", "List Size ${newsList.size}")
        return newsList
    }

    private fun getRandomLengthString(str:String) : String {
        val n = (1 .. 20).random()
        val builder = StringBuilder()
        repeat(n) {
            builder.append(str)
        }
        return builder.toString()
    }


}