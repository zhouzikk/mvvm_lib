package com.zhouzi.library.databinding

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.IntRange
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("textStyle")
fun setTextStyle(view: TextView, @IntRange(from = 0, to = 2) typeface: Int) {
    view.paint.typeface = Typeface.defaultFromStyle(typeface)
}

@BindingAdapter("drawableBottom")
fun setDrawableBottom(view: TextView, drawableRes: Int) {
    val drawable = view.context.getDrawable(drawableRes)
    setIntrinsicBounds(drawable)
    val drawables = view.compoundDrawables
    view.setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawable)
}

@BindingAdapter("drawableLeft")
fun setDrawableLeft(view: TextView, drawableRes: Int) {
    val drawable = view.context.getDrawable(drawableRes)
    setIntrinsicBounds(drawable)
    val drawables = view.compoundDrawables
    view.setCompoundDrawables(drawable, drawables[1], drawables[2], drawables[3])
}

@BindingAdapter("drawableRight")
fun setDrawableRight(view: TextView, drawableRes: Int) {
    val drawable = view.context.getDrawable(drawableRes)
    setIntrinsicBounds(drawable)
    val drawables = view.compoundDrawables
    view.setCompoundDrawables(
        drawables[0], drawables[1], drawable,
        drawables[3]
    )
}

@BindingAdapter("drawableTop")
fun setDrawableTop(view: TextView, drawableRes: Int) {
    val drawable = view.context.getDrawable(drawableRes)
    setIntrinsicBounds(drawable)
    val drawables = view.compoundDrawables
    view.setCompoundDrawables(
        drawables[0], drawable, drawables[2],
        drawables[3]
    )
}

@BindingAdapter("drawableStart")
fun setDrawableStart(view: TextView, drawableRes: Int) {
    if (drawableRes != 0) {
        val drawable = view.context.getDrawable(drawableRes)
        setIntrinsicBounds(drawable)
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            setDrawableLeft(view, drawableRes)
        } else {
            setIntrinsicBounds(drawable)
            val drawables = view.compoundDrawablesRelative
            view.setCompoundDrawablesRelative(
                drawable,
                drawables[1],
                drawables[2],
                drawables[3]
            )
        }
    }
}

@BindingAdapter("drawableEnd")
fun setDrawableEnd(view: TextView, @DrawableRes drawableRes: Int) {
    if (drawableRes != -1) {
        val drawable = view.context.getDrawable(drawableRes)
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
//            setDrawableRight(view, drawableRes)
//        } else {
        setIntrinsicBounds(drawable)
        val drawables = view.compoundDrawablesRelative
        view.setCompoundDrawablesRelative(
            drawables[0],
            drawables[1],
            drawable,
            drawables[3]
        )
    } else {
        val drawables = view.compoundDrawablesRelative
        view.setCompoundDrawablesRelative(
            drawables[0],
            drawables[1],
            null,
            drawables[3]
        )
    }
}

private fun setIntrinsicBounds(drawable: Drawable?) {
    drawable?.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
}

@BindingAdapter("textFromHtml")
fun textFromHtml(view: TextView, content: String) {
    view.text = HtmlCompat.fromHtml(content, HtmlCompat.FROM_HTML_MODE_COMPACT)
}