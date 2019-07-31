package com.alma.trustwallettest.data

import com.alma.trustwallettest.domain.Coin

class CoinRepository {

    private val coins: List<Coin> = listOf(
        Coin(1, "BTC"),
        Coin(2, "ETH"),
        Coin(3, "XRP"),
        Coin(4, "MITH"),
        Coin(5, "BNB")
    )

    private var lastUsedCoins = Pair(coins[0], coins[1])

    fun getCoins(): List<Coin> {
        return coins
    }

    fun setLastUsedCoinExchangeFrom(coin: Coin) {
        lastUsedCoins = Pair(coin, lastUsedCoins.second)
    }

    fun setLastUsedCoinExchangeTo(coin: Coin) {
        lastUsedCoins = Pair(lastUsedCoins.first, coin)
    }

    fun getLastUsedCoins(): Pair<Coin, Coin> {
        return lastUsedCoins
    }
}