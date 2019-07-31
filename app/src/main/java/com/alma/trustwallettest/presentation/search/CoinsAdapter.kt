package com.alma.trustwallettest.presentation.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alma.trustwallettest.R
import com.alma.trustwallettest.domain.Coin
import kotlinx.android.synthetic.main.item_coin.view.*

class CoinViewHolder(
    itemView: View,
    val onClick: (coin: Coin) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    fun bind(coin: Coin) {
        itemView.amount.text = "${coin.amount} ${coin.name}"
        itemView.coin_img.setImageDrawable(itemView.context.getDrawable(coin.iconRes))
        itemView.coin_name.text = coin.name

        itemView.setOnClickListener { onClick.invoke(coin) }
    }
}

class CoinsAdapter(context: Context,
                   val onClick: (coin: Coin) -> Unit) : RecyclerView.Adapter<CoinViewHolder>() {

    private val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    private val items: MutableList<Coin> = mutableListOf()

    fun setItems(coins: List<Coin>) {
        items.clear()
        items.addAll(coins)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view = inflater.inflate(R.layout.item_coin, parent, false)
        return CoinViewHolder(view, onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(items[position])
    }
}