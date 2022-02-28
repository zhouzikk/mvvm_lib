package com.zhouzi.library.databinding

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.zhouzi.library.util.GlideUtils

@BindingAdapter("imageSrc")
fun bindIcon(imageView: ImageView, @DrawableRes resId: Int) {
    imageView.setImageResource(resId)
}

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, imageUrl: String?) {
    GlideUtils.loadImage(
        imageView.context,
        imageUrl,
        imageView
    )
}

@BindingAdapter("imageUrl", "defaultRes", "errorRes")
fun loadImage(imageView: ImageView, imageUrl: String?, defaultRes: Int, errorRes: Int) {
    GlideUtils.loadImage(
        imageView.context,
        imageUrl,
        defaultRes = defaultRes,
        errorRes = errorRes,
        imageView
    )
}