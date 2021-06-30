package com.mc.cpyr.basekittest.biz

import com.alibaba.android.arouter.facade.annotation.Route
import com.kit.base.fragment.DataBindingFragment
import com.kit.base.view.state.state
import com.kit.base.viewmodel.BaseViewModel
import com.mc.cpyr.basekittest.R
import com.mc.cpyr.basekittest.databinding.FragmentStateBinding
import com.mc.cpyr.kit.ext.logI
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * StateFragment
 *
 * @author mmxm
 * @date 2021/6/28 20:03
 */
@Route(path = "/app/StateFragment")
class StateFragment :DataBindingFragment<FragmentStateBinding,BaseViewModel>(){
    override fun getLayoutId(): Int {
        return R.layout.fragment_state
    }

    override fun getViewModel(): BaseViewModel {
        return BaseViewModel()
    }

    override fun initView() {
        val stateLayout=mBinding.targetLayout.state().onRefresh {
            this@StateFragment.scope.launch {
                delay(2000)
                showContent()
            }
        }.showLoading()
        mBinding.emptyBtn.setOnClickListener {
            logI { "${mBinding.targetLayout.state().hashCode()}" }
            logI { "${stateLayout.hashCode()}" }
            stateLayout.showEmpty()
        }
        mBinding.errorBtn.setOnClickListener {
            stateLayout.showError()
        }
        mBinding.loadingBtn.setOnClickListener {
            stateLayout.showLoading()

        }
        mBinding.defaultBtn.setOnClickListener {
            stateLayout.showContent()
        }





    }

    override fun initViewData() {

    }

    override fun initObserver() {

    }
}