package com.mc.cpyr.basekittest

import com.mm.ext.launch
import com.skt.lib.viewModel.AbsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 * TestViewModel
 *
 * @author mmxm
 * @date 2021/6/18 15:37
 */
class TestViewModel : AbsViewModel() {
    fun login() {
        launch {
            showLoading("哈哈哈")
            withContext(Dispatchers.IO){
                delay(3000)
            }
            hideLoading()
        }
    }
    fun login2() {
        launch {
            showLoading("虎虎虎")
            withContext(Dispatchers.IO){
                delay(3000)
            }
            hideLoading()
        }
    }
}