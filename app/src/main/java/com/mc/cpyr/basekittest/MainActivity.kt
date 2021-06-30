package com.mc.cpyr.basekittest

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.drakeet.multitype.MultiTypeAdapter
import com.kit.base.activity.DataBindingActivity
import com.kit.base.adapter.holder.AbsViewHolder
import com.kit.base.adapter.binder.CommonViewBinder
import com.kit.base.viewmodel.BaseViewModel
import com.mc.cpyr.basekittest.databinding.ActivityMainBinding
import com.mc.cpyr.kit.ext.logI
import com.mm.ext.DividerDrawable
import com.mm.ext.dividerLine
import com.skt.lib.helper.startFragment

class MainActivity : DataBindingActivity<ActivityMainBinding, BaseViewModel>() {


    private val adapter by lazy {
        val adapter=MultiTypeAdapter()
        adapter.register(BizBean::class.java,object : CommonViewBinder<BizBean>(R.layout.item_list_view){
            override fun onCreateHolder(itemView: View): AbsViewHolder<BizBean> {
                return TestCommonViewHolder(itemView)
            }
        }.apply {
            setOnItemClickListener{ adapter: MultiTypeAdapter, view: View, i: Int ->
               val item= adapter.items[i] as BizBean
                item.runnable?.run()
            }
        })

        adapter
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
    override fun getViewModel(): BaseViewModel {
        return BaseViewModel()
    }

    override fun initView() {

        mBinding.recyView.layoutManager=LinearLayoutManager(this)
        mBinding.recyView.adapter=adapter
        mBinding.recyView.dividerLine{
            DividerDrawable(1).also { d ->
                d.color = 0xffC8C8C8.toInt()
            }
        }
    }

    override fun initViewData() {
        val list= mutableListOf<BizBean>()
        list.add(BizBean("缺省页") {
            startFragment("/app/StateFragment")
        })
        list.add(BizBean("定时器") {
            startFragment("/app/CounterFragment")
        })
        adapter.items=list
        adapter.notifyDataSetChanged()
    }

}





