package com.mc.cpyr.basekittest

import android.app.Application
import com.kit.base.app.BaseAppDelegate
import com.kit.base.app.BaseApplication
import com.mc.cpyr.kit.app.DefaultAppDelegate

/**
 * App
 *
 * @author mmxm
 * @date 2021/6/16 15:31
 */
class App : BaseApplication() {
    override fun createDelegate(): BaseAppDelegate {
        return object : DefaultAppDelegate(this){

        }
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG)
            com.didichuxing.doraemonkit.DoKit.Builder(this)
                .productId("需要使用平台功能的话，需要到dokit.cn平台申请id")
                .build()

    }
}