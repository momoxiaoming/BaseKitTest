package com.mc.cpyr.basekittest

import androidx.lifecycle.Lifecycle
import com.alibaba.android.arouter.facade.annotation.Route
import com.kit.base.fragment.DataBindingFragment
import com.kit.base.viewmodel.BaseViewModel
import com.mc.cpyr.basekittest.databinding.FragmentCounterBinding
import com.mm.kit.common.time.Counter
import com.skt.lib.ui.fragment.LoadDataBindingFragment
import com.skt.lib.viewModel.AbsViewModel

/**
 * CounterFragment
 *
 * @author mmxm
 * @date 2021/4/14 14:59
 */
@Route(path = "/app/CounterFragment")
class CounterFragment : LoadDataBindingFragment<FragmentCounterBinding, TestViewModel>() {


    override fun getLayoutId(): Int {
        return R.layout.fragment_counter
    }

    override fun getViewModel(): TestViewModel {
        return TestViewModel()
    }

    override fun initLayout() {
//        SystemUiUtil.immersiveSystemUi(requireActivity().window)
        mBinding.btn.setOnClickListener {
            mModel.login()
        }
        mBinding.btn2.setOnClickListener {
            mModel.login2()
        }
    }

    override fun initView() {
    }

    override fun initViewData() {
    }

}

