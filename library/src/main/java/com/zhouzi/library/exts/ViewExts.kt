package com.zhouzi.library.exts

import android.view.View
import com.blankj.utilcode.util.ClickUtils

/**
 * Created by ZhouZi on 2021/5/24.
 * time:11:56
 */
fun View.click(c: (View?) -> Unit) {
    setOnClickListener(object : ClickUtils.OnDebouncingClickListener(500) {
        override fun onDebouncingClick(v: View?) {
            c(v)
        }
    })
}
