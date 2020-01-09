package com.augrocerrydelivery.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.augrocerrydelivery.audeliveryapp.R
import com.augrocerrydelivery.ui.adapter.OrderListAdapter
import kotlinx.android.synthetic.main.orderlistfragment.*


class OrderListFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.orderlistfragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpElements()
    }

    private fun setUpElements() {
        val mLayoutManager =
            LinearLayoutManager(context)
        recylerViewOrderList.layoutManager = mLayoutManager
        recylerViewOrderList.adapter = OrderListAdapter(context!!)

    }
}