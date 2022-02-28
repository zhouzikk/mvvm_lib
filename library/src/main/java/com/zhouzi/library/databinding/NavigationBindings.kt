package com.zhouzi.library.databinding

import androidx.annotation.NavigationRes
import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController

/**
 * Created by ZhouZi on 2021/8/2.
 * time:16:15
 */
@BindingAdapter("navGraph")
fun bindIcon(fragment: FragmentContainerView, @NavigationRes resId: Int) {
    fragment.findNavController().setGraph(resId)
}