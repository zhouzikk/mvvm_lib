package com.zhouzi.library.databinding

import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter("visible")
fun visible(view: View, visible: Boolean) {
    view.isVisible = visible
}

@BindingAdapter("background")
fun background(view: View, @DrawableRes resId: Int) {
    view.setBackgroundResource(resId)
}

