package com.example.fragmenttest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmenttest.R
import com.example.fragmenttest.databinding.FragmentLeftBinding
import com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener

class FragmentLeft : Fragment() {

    private var _binding: FragmentLeftBinding? = null
    private val binding get() = _binding

    // 定义接口
    interface onButtonClickListener {
        fun onLeftButtonClick()
    }
    private var listener: onButtonClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLeftBinding.inflate(inflater, container, false)
        return binding?.root
        //return inflater.inflate(R.layout.fragment_left, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.leftButton?.setOnClickListener {
            listener?.onLeftButtonClick()
        }
    }

    // 设置监听器
    fun setOnButtonClickListener(listener: onButtonClickListener){
        this.listener = listener
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        listener = null
    }
}