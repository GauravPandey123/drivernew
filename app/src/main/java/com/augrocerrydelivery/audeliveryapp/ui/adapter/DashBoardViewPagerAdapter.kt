package com.augrocerrydelivery.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.augrocerrydelivery.ui.fragment.OrderListFragment


class DashBoardViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        return OrderListFragment()
    }

    override fun getItemCount(): Int {
        return CARD_ITEM_SIZE
    }

    companion object {
        private const val CARD_ITEM_SIZE = 3
    }
}