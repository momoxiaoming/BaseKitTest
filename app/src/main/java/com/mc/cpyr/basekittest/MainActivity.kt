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
import com.mm.ext.launch
import com.mm.kit.common.color.ColorUtils
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

class MainActivity : DataBindingActivity<ActivityMainBinding, BaseViewModel>() {
    private val adapter: ItemAdapter by lazy {
        ItemAdapter(R.layout.item_layout)
    }

    fun replaseFragment(fragment: Fragment) {
        lifecycleScope.launch {
            supportFragmentManager.commit {
                replace(android.R.id.content, fragment)
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initLayout() {
        super.initLayout()



    }

    override fun getViewModel(): BaseViewModel {
        return BaseViewModel()
    }


}



class ItemAdapter(layoutResId: Int) : BaseQuickAdapter<String, BaseViewHolder>(layoutResId) {
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.itemView.setBackgroundColor(ColorUtils.randomColor())
        holder.setText(R.id.item_tv, item)
    }

}

