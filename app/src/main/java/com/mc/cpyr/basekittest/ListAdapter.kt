package com.mc.cpyr.basekittest

import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.skt.lib.ui.list.AbsStateAdapter

/**
 * ListAdapter
 *
 * @author mmxm
 * @date 2021/6/23 17:53
 */
class ListAdapter(layoutResId: Int = R.layout.item_layout) :
    AbsStateAdapter<String, BaseViewHolder>(layoutResId) {
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.item_tv, item)
    }
}