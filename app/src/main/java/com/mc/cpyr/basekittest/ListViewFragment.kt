package com.mc.cpyr.basekittest

import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.mc.cpyr.basekittest.databinding.FragmentListBinding
import com.mc.cpyr.kit.ext.logI
import com.skt.lib.ui.list.state.DefaultLoadingView
import com.skt.lib.ui.adapter.LoadMoreListener
import com.skt.lib.ui.adapter.RefreshListener
import com.skt.lib.ui.fragment.LoadDataBindingFragment
import com.skt.lib.ui.list.state.DefaultEmptyView
import com.skt.lib.ui.list.state.DefaultErrorView
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

/**
 * ListViewFragment
 *
 * @author mmxm
 * @date 2021/6/23 17:29
 */
@Route(path = "/app/listFragment")
class ListViewFragment :LoadDataBindingFragment<FragmentListBinding, TestViewModel>() {
    private var page=1
    private val adapter by lazy {
        ListAdapter().also {
            it.setStateView(
                DefaultLoadingView(requireActivity()).also {item->
                    item.addStateViewListener{ d->
                        //这里属于刷新范畴,需要将page至1
                        mBinding.stateRecycleView.resetPage()
                        refreshData(mBinding.stateRecycleView.page)
                    }
                },
                DefaultErrorView(requireActivity()).also {item->
                    item.addStateViewListener{ d->
                        //这里属于刷新范畴,需要将page至1
                        mBinding.stateRecycleView.resetPage()
                        refreshData(mBinding.stateRecycleView.page)
                    }
                },
                DefaultEmptyView(requireActivity()).also { item->
                item.addStateViewListener{ d->
                    //这里属于刷新范畴,需要将page至1
                    mBinding.stateRecycleView.resetPage()
                    refreshData(mBinding.stateRecycleView.page)
                }
            })
        }
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_list
    }

    override fun getViewModel(): TestViewModel {
       return TestViewModel()
    }

    override fun initView() {
        val list= mutableListOf<String>()
        for(i in 0..20){
            list.add("item->$i")
        }
        mBinding.stateRecycleView.initConfig(LinearLayoutManager(requireContext()),adapter,true)
        mBinding.stateRecycleView.setOnRefreshListener(object :RefreshListener{
            override fun onRefreshListener() {
                refreshData(mBinding.stateRecycleView.page)
            }
        })
        mBinding.stateRecycleView.setOnLoadMoreListener(object :LoadMoreListener{
            override fun onLoadMoreListener() {
                loadMoreData(mBinding.stateRecycleView.page)
            }
        })

        refreshData(mBinding.stateRecycleView.page)
    }

    fun getData():MutableList<String>{
        val list= mutableListOf<String>()
        for(i in 0..10){
            list.add("item->$i")
        }
        return list
    }

    override fun initViewData() {

    }

    fun refreshData(page:Int){
        scope.launch {
            delay(2000)
            //得到数据
            val num= Random.nextInt(0,3)
            logI { "refreshData--page>$page----num->$num" }

            when(num){
                0->{
                    mBinding.stateRecycleView.setListData(true,getData())
                }
                1->{
                    mBinding.stateRecycleView.setListData(true,null)
                }
                2->{
                    mBinding.stateRecycleView.setListData(true, mutableListOf<String>())
                }
            }

        }
    }

    fun loadMoreData(page:Int){
        scope.launch {
            delay(200)
            //得到数据
           val num= Random.nextInt(0,3)
            logI { "loadMoreData--page>$page----num->$num" }

            when(num){
                0->{
                    mBinding.stateRecycleView.setListData(true,getData())
                }
                1->{
                    mBinding.stateRecycleView.setListData(false,null)
                }
                2->{
                    mBinding.stateRecycleView.setListData(false,mutableListOf<String>())

                }
            }

        }
    }
}