package com.mc.cpyr.basekittest

import android.util.Log
import androidx.lifecycle.Lifecycle
import com.alibaba.android.arouter.facade.annotation.Route
import com.kit.base.fragment.DataBindingFragment
import com.kit.base.viewmodel.BaseViewModel
import com.mc.cpyr.basekittest.databinding.FragmentCounterBinding
import com.mm.kit.common.time.Counter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * CounterFragment
 *
 * @author mmxm
 * @date 2021/4/14 14:59
 */
@Route(path = "/app/CounterFragment")
class CounterFragment : DataBindingFragment<FragmentCounterBinding, BaseViewModel>() {


    override fun getLayoutId(): Int {
        return R.layout.fragment_counter
    }

    override fun getViewModel(): BaseViewModel {
        return BaseViewModel()
    }


    override fun initObserver() {

    }

    override fun initView() {
        mBinding.btn.setOnClickListener {
            Counter(this, Lifecycle.Event.ON_DESTROY, 10, 1).subscribe {
                mBinding.text.text="$it"
            }.subscribeFinish {
                mBinding.text.text="倒计时完成"
            }.start()
        }
    }
    override fun initViewData() {
    }
}

