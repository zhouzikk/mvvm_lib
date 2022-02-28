package com.zhouzi.library.exception

/**
 * Created by ZhouZi on 2021/5/19.
 * time:11:11
 */
class BusinessException(val code: String, message: String?) : Exception(message) {

    override val message: String
        get() = super.message ?: "未知"

}