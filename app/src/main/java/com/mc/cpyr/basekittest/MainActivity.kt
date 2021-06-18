package com.mc.cpyr.basekittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.doOnLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kit.base.activity.DataBindingActivity
import com.kit.base.viewmodel.BaseViewModel
import com.mc.cpyr.basekittest.databinding.ActivityMainBinding
import com.mc.cpyr.kit.ext.logI
import com.mc.cpyr.kit.util.Debuger
import com.mm.ext.IE
import com.mm.ext.launch
import com.mm.kit.common.color.ColorUtils
import com.mm.kit.common.log.VLog
import com.skt.lib.helper.startFragment
import com.skt.lib.helper.startFullFragment
import com.skt.lib.helper.startTitleFragment
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

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


}





