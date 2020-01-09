package com.augrocerrydelivery.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.augrocerrydelivery.audeliveryapp.R
import com.augrocerrydelivery.ui.adapter.DashBoardViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.dashboard_fragment.*


class DashBoardFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dashboard_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpElements()
    }

    private fun setUpElements() {
        // Must be declared before TabLayoutMediator.attach()
        viewpagerDashBoard.adapter = createCardAdapter()
        TabLayoutMediator(tabLayoutDashBoard, viewpagerDashBoard,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                // Styling each tab here
                when (position) {
                    0->
                        tab.text = activity?.resources?.getString(R.string.newOrder)
                    1 ->
                        tab.text = activity?.resources?.getString(R.string.inprocess)
                    2 ->
                        tab.text = activity?.resources?.getString(R.string.order_history)

                }
            }).attach()


    }

    private fun createCardAdapter(): DashBoardViewPagerAdapter? {
        return DashBoardViewPagerAdapter(activity!!)
    }


}