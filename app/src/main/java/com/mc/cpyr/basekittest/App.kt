package com.mc.cpyr.basekittest

import android.app.Application

/**
 * App
 *
 * @author mmxm
 * @date 2021/6/16 15:31
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        com.didichuxing.doraemonkit.DoKit.Builder(this)
            .productId("需要使用平台功能的话，需要到dokit.cn平台申请id")
            .build()

    }
}