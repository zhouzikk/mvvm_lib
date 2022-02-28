package com.zhouzi.library.base.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.google.gson.JsonSyntaxException
import com.zhouzi.library.exception.BusinessException
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by ZhouZi on 2021/5/19.
 * time:10:37
 */
open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    val requestState by lazy { MutableLiveData(State.NONE) }
    val logoutAll by lazy { MutableLiveData(false) }


    fun launch(
        start: (() -> Unit)? = null,
        block: suspend () -> Unit,
        error: ((BusinessException) -> Unit)? = null,
        finally: (() -> Unit)? = null,
        showProgress: Boolean = true
    ) {
        if (showProgress)
            requestState.postValue(State.LOADING)
        viewModelScope.launch {
            try {
                block()
                requestState.postValue(State.SUCCESS)
            } catch (e: Exception) {
                e.printStackTrace()
                requestState.postValue(State.ERROR)
                when (e) {
                    is BusinessException -> {
                        if (e.code == "100000") {
                            logoutAll.postValue(true)
                        }
                        ToastUtils.showShort(e.message)
                        error?.invoke(e)
                    }
                    is HttpException ->
                        when (e.code()) {
                            404 -> ToastUtils.showShort("网络连接失败：您所请求的资源无法找到\n错误码：${e.code()}\n详细信息：${e.message()}")
                            500 -> ToastUtils.showShort("网络连接失败：服务器异常，请稍后再试\n错误码：${e.code()}\n详细信息：${e.message()}")
                            else -> ToastUtils.showShort("网络连接失败：网络异常，请稍后再试\n错误码：${e.code()}\n详细信息：${e.message()}")
                        }
                    is UnknownHostException,
                    is ConnectException,
                    is SocketTimeoutException -> {
                        ToastUtils.showShort("网络连接失败：网络异常，请稍后再试\n详细信息：${e.message}")
                    }
                    is JSONException -> ToastUtils.showShort("数据错误：服务器数据异常\n详细信息：${e.message}")
                    is JsonSyntaxException -> ToastUtils.showShort("数据错误：服务器数据异常\n详细信息：${e.message}")
                    is NoSuchFileException -> ToastUtils.showShort("文件不存在")
                    is CancellationException -> {
                        LogUtils.e(e)
                    }
                    else -> {
                        ToastUtils.showShort("未知错误：未知原因错误\n详细信息：${e.message}")
                    }
                }
            } finally {
                finally?.invoke()
                delay(100)
                requestState.postValue(State.END)
            }
        }
    }


}

enum class State {
    NONE,
    LOADING,
    SUCCESS,
    EMPTV,
    CODE_ERROR,
    ERROR,
    END
}