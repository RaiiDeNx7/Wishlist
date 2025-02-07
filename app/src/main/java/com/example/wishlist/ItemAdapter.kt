package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishlistAdapter(private val itemList: List<Item>) :
    RecyclerView.Adapter<WishlistAdapter.WishlistViewHolder>() {

    class WishlistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.itemInput)
        val itemPrice: TextView = itemView.findViewById(R.id.itemCost)
        val itemLink: TextView = itemView.findViewById(R.id.linkInput)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishlistViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)
        return WishlistViewHolder(view)
    }

    override fun onBindViewHolder(holder: WishlistViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemName.text = item.name
        holder.itemPrice.text = item.cost
        holder.itemLink.text = item.link
    }

    override fun getItemCount(): Int = itemList.size
}