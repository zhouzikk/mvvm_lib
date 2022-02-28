package com.zhouzi.library.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.zhouzi.library.R
import com.zhouzi.library.databinding.ViewYToolbarBinding

/**
 * Created by ZhouZi on 2021/5/20.
 * time:10:41
 */
class YToolbar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : Toolbar(context, attrs, defStyleAttr) {


    private var binding: ViewYToolbarBinding? =
        DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.view_y_toolbar, this, true)

    init {

        attrs?.let {
            context.obtainStyledAttributes(it, R.styleable.YToolbar).run {
                if (getBoolean(R.styleable.YToolbar_showNavigation, true))
                    navigationIcon = getDrawable(R.styleable.YToolbar_yNavigationIcon)
                binding?.centerTitle?.text = getText(R.styleable.YToolbar_centerTitle)
                title = getText(R.styleable.YToolbar_leftTitle)
                getColorStateList(R.styleable.YToolbar_titleTextColor)?.let { color ->
                    setTitleTextColor(color)
                    binding?.centerTitle?.setTextColor(color)
                }
                recycle()
            }

        }

        setContentInsetsRelative(0, 0)

    }

    fun setCenterTitle(resId: Int) {
        binding?.centerTitle?.setText(resId)
    }

    fun setCenterTitle(char: CharSequence?) {
        binding?.centerTitle?.text = char ?: ""
    }

}