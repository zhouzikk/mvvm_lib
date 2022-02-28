package com.zhouzi.library.base

import android.app.Application
import com.blankj.utilcode.util.Utils

/**
 * Created by ZhouZi on 2021/5/19.
 * time:10:12
 */
open class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
    }

}