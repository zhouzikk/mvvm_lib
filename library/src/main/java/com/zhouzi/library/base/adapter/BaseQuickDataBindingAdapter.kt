package com.zhouzi.library.base.adapter

import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder

/**
 * Created by ZhouZi on 2021/5/19.
 * time:17:25
 */
abstract class BaseQuickDataBindingAdapter<B : ViewDataBinding, T>(
    layoutResId: Int,
    data: MutableList<T>? = null
) :
    BaseQuickAdapter<T, BaseDataBindingHolder<B>>(layoutResId, data)