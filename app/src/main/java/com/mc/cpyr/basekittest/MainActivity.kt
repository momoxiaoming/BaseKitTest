package com.mc.cpyr.basekittest

import android.os.Build
import androidx.annotation.RequiresApi
import com.kit.base.activity.DataBindingActivity
import com.kit.base.viewmodel.BaseViewModel
import com.mc.cpyr.basekittest.databinding.ActivityMainBinding
import com.mc.cpyr.kit.ext.logI
import com.mm.ext.IE
import com.skt.lib.ui.view.GOrientation

class MainActivity : DataBindingActivity<ActivityMainBinding, BaseViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun initLayout() {
        super.initLayout()

        mBinding.cardView.setOnClickListener {
//            startFragment("/app/CounterFragment")
//            startTitleFragment("/app/CounterFragment")
            val s = true.IE({ "111" }, { 1 })
            logI { s }
        }


//        val view:GradientDrawable
//        view.cornerRadii= floatArrayOf(1f,1f)

        test(-1)

//        val drawable= DelegateDrawable()
//        val norDrawable= ColorDrawable()
//        norDrawable.color = getColor(R.color.purple_700)
//        val pressDrawable=ColorDrawable()
//        pressDrawable.color = getColor(R.color.purple_200)
//
//        val pressDrawable2=ColorDrawable()
//        pressDrawable2.color = getColor(R.color.teal_200)
//
////        drawable.addState(intArrayOf(-android.R.attr.state_pressed),norDrawable)
////        drawable.addState(intArrayOf(android.R.attr.state_pressed),pressDrawable)
//        drawable.addState(intArrayOf(android.R.attr.state_enabled),pressDrawable)
//
//        drawable.addState(intArrayOf(0),norDrawable)
//        mBinding.cardView.backgroundDrawable=drawable
//        mBinding.cardView.isEnabled=false


    }
    fun test(@GOrientation int: Int){

    }

    override fun getViewModel(): BaseViewModel {
        return BaseViewModel()
    }

    override fun initView() {

    }

    override fun initViewData() {

    }

}





