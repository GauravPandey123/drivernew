package com.augrocerrydelivery.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.augrocerrydelivery.audeliveryapp.R

class OrderListAdapter(val context: Context) :
    RecyclerView.Adapter<OrderListAdapter.OrderViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.order_footer_item, parent, false)
        return OrderViewHolder(view)

    }


    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
    }

    inner class OrderViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val relativeLayoutCard = view.findViewById<RelativeLayout>(R.id.relativeLayoutCard)
        val imagevIewCardView = view.findViewById<ImageView>(R.id.imagevIewCardView)
        val textViewOrderName = view.findViewById<TextView>(R.id.textViewOrderName)
        val textViewOrderLocation = view.findViewById<TextView>(R.id.textViewOrderLocation)
        val textViewOrderStatus = view.findViewById<TextView>(R.id.textViewOrderStatus)
        val textViewScheduleTime = view.findViewById<TextView>(R.id.textViewScheduleTime)
    }
}