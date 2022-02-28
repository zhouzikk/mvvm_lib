package com.zhouzi.library.constant

/**
 * Created by ZhouZi on 2021/5/24.
 * time:16:16
 */
object RegexConfig {

    /**
     * 8-16 字母+数字
     */
    const val PWD_8_16 = "^(?=.*\\d)(?=.*[a-zA-Z])[a-zA-Z0-9]{8,16}\$"

    /**
     * 6-30 字母+数字
     */
    const val PWD_6_30 = "^(?=.*\\d)(?=.*[a-zA-Z])[a-zA-Z0-9]{6,30}\$"

    /**
     * 1位小数
     */
    const val DECIMAL_1 = "^[0-9]+(.[0-9]{1})?\$"

    /**
     * 2位小数
     */
    const val DECIMAL_2 = "^[0-9]+(.[0-9]{2})?\$"

    /**
     * 0_2位小数
     */
    const val DECIMAL_0_2 = "^[0-9]+(.[0-9]{0,2})?\$"

}