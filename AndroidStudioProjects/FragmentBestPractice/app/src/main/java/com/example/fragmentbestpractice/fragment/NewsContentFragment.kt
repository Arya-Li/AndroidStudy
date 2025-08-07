package com.example.fragmentbestpractice.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentbestpractice.databinding.NewsContentFragBinding

class NewsContentFragment : Fragment() {

    // 使用viewBinding
    private var _binding : NewsContentFragBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = NewsContentFragBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun refresh(title : String, content : String) {
        binding.contentLayout.visibility = View.VISIBLE
        binding.newsTitle.text = title
        binding.newsContent.text = content
    }


}