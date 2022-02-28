package com.zhouzi.library.base.model

import android.app.Application
import androidx.lifecycle.MutableLiveData

/**
 * Created by ZhouZi on 2020/10/15.
 * time:10:15
 */
abstract class BasePagingViewModel<T>(application: Application) : BaseViewModel(application) {

    val hasMore by lazy { MutableLiveData(false) }

    var page = 0

    val pageSize = 20

    val listData by lazy {
        MutableLiveData<MutableList<T>>()
    }

    fun isFirstPage() = page == 1

    open fun refresh() {
        page = 0
        loadData()
    }

    abstract fun loadData()

}