package com.zhouzi.library.base.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by ZhouZi on 2021/5/19.
 * time:10:36
 */
abstract class YActivity<B : ViewDataBinding>(private val layoutId:Int) : AppCompatActivity() {

    lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
        initView()
    }

    abstract fun initView()

}