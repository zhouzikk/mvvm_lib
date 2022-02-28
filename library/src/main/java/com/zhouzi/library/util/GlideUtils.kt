package com.zhouzi.library.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zhouzi.library.exception.BusinessException

/**
 * Created by ZhouZi on 2021/6/22.
 * time:9:19
 */
object GlideUtils {

    private var options: RequestOptions? = null

    fun init(errorRes: Int, defaultRes: Int) {
        options = RequestOptions()
            .placeholder(defaultRes)
            .fallback(defaultRes)
            .error(errorRes)
    }

    fun loadImage(c: Context, path: String?, view: ImageView) {
        if (options == null) {
            throw BusinessException("-1", "GlideUtils没有init")
        }
        val x: String? = null
        Glide.with(c).load(if (path.isNullOrEmpty()) x else path).apply(options!!)
            .into(view)
    }

    fun loadImage(c: Context, path: String?, defaultRes: Int, errorRes: Int, view: ImageView) {
        val x: String? = null
        val options = RequestOptions()
            .placeholder(defaultRes)
            .fallback(defaultRes)
            .error(errorRes)
        Glide.with(c).load(if (path.isNullOrEmpty()) x else path).apply(options)
            .into(view)
    }

}