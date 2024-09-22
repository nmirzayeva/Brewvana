package com.nurlanamirzayeva.brewvana.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nurlanamirzayeva.brewvana.Model.ItemsModel
import com.nurlanamirzayeva.brewvana.databinding.ViewholderPopularBinding

class PopularAdapter(val items: MutableList<ItemsModel>) :
    RecyclerView.Adapter<PopularAdapter.Viewholder>() {


    private var contex: Context? = null

    class Viewholder(val biding: ViewholderPopularBinding) : RecyclerView.ViewHolder(biding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularAdapter.Viewholder {
        contex = parent.context
        val bilding = ViewholderPopularBinding.inflate(LayoutInflater.from(contex), parent, false)
        return Viewholder(bilding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PopularAdapter.Viewholder, position: Int) {
        holder.biding.titleTxt.text=items[position].title
        holder.biding.priceTxt.text="$"+items[position].price.toString()
        holder.biding.ratingBar.rating=items[position].rating.toFloat()
        holder.biding.extraTxt.text=items[position].extra

        Glide.with(holder.itemView.context)
            .load(items[position].picUrl[0])
            .into(holder.biding.pic)

        holder.itemView.setOnClickListener {

        }

    }

    override fun getItemCount(): Int = items.size


}