package com.zhouzi.library.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import com.zhouzi.library.R

/**
 * Created by ZhouZi on 2021/5/26.
 * time:10:20
 */
open class YDialog<B : ViewDataBinding>(val layoutId: Int) :
    DialogFragment() {

    lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle()
    }

    open fun setStyle() {
        setStyle(STYLE_NORMAL, R.style.YDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }
}