package com.mc.cpyr.basekittest

import com.kit.base.activity.DataBindingActivity
import com.kit.base.viewmodel.BaseViewModel
import com.mc.cpyr.basekittest.databinding.ActivityMainBinding
import com.mc.cpyr.kit.ext.logI
import com.mm.ext.IE
import com.skt.lib.helper.startFragment

class MainActivity : DataBindingActivity<ActivityMainBinding, BaseViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initLayout() {
        super.initLayout()

        mBinding.btn.setOnClickListener {
            startFragment("/app/CounterFragment")
//            startTitleFragment("/app/CounterFragment")
            val s = true.IE({ "111" }, { 1 })
            logI { s }
        }


    }

    override fun getViewModel(): BaseViewModel {
        return BaseViewModel()
    }

    override fun initView() {
        TODO("Not yet implemented")
    }

    override fun initViewData() {
        TODO("Not yet implemented")
    }


}





