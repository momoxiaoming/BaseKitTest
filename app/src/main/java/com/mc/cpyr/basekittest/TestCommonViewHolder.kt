package com.mc.cpyr.basekittest

import android.view.View
import com.kit.base.adapter.holder.AbsViewHolder
import com.kit.base.adapter.holder.DataBindingViewHolder
import com.mc.cpyr.basekittest.databinding.ItemListViewBinding

/**
 * TestCommonViewHolder
 *
 * @author mmxm
 * @date 2021/6/30 11:27
 */
class TestCommonViewHolder(itemView: View) : DataBindingViewHolder<BizBean,ItemListViewBinding>(itemView) {
    override fun bindingData(data: BizBean) {
        mBinding.itemTv.text=data.title
    }

}