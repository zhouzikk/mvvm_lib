package com.zhouzi.library.databinding

import android.util.Log
import androidx.databinding.BindingAdapter
import com.zhouzi.library.base.model.State
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener
import com.scwang.smart.refresh.layout.listener.OnRefreshListener

@BindingAdapter(value = ["onRefresh", "onLoadMore"], requireAll = false)
fun refreshLoadListener(
    layout: SmartRefreshLayout,
    onRefresh: OnRefreshListener?,
    onLoadMore: OnLoadMoreListener?
) {
    layout.setOnRefreshListener(onRefresh)
    layout.setOnLoadMoreListener(onLoadMore)
}

@BindingAdapter(value = ["state"], requireAll = false)
fun state(layout: SmartRefreshLayout, state: State) {
    Log.e("BindingAdapter", state.name)

    when (state) {
        State.SUCCESS -> {
            layout.finishRefresh(true)
            layout.finishLoadMore(true)
        }
        State.ERROR -> {
            layout.finishRefresh(false)
            layout.finishLoadMore(false)
        }
        else -> {

        }
    }

}

@BindingAdapter(value = ["hasMore"], requireAll = false)
fun hasMore(layout: SmartRefreshLayout, hasMore: Boolean) {
    if (!hasMore)
        layout.finishLoadMoreWithNoMoreData()
}

