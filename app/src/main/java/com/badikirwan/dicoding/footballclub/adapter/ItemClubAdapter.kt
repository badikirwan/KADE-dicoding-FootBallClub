package com.badikirwan.dicoding.footballclub.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.badikirwan.dicoding.footballclub.UI.ItemClubUI
import com.badikirwan.dicoding.footballclub.model.Item
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext

class ItemClubAdapter(val items: List<Item>, val listener: (Item) -> Unit) :
        RecyclerView.Adapter<ItemClubAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(ItemClubUI().createView(AnkoContext.create(parent.context)))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    inner class ViewHolder(override val containerView : View) :
            RecyclerView.ViewHolder(containerView), LayoutContainer {

        private val imageClub : ImageView = itemView.findViewById(ItemClubUI.clubImageId)
        private val nameClub : TextView = itemView.findViewById(ItemClubUI.clubNameId)

        fun bindItem(items: Item, listener: (Item) -> Unit) {
            nameClub.text = items.name

            Glide.with(itemView.context)
                    .load(items.image)
                    .into(imageClub)

            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}