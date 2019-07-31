package com.alma.trustwallettest.domain

interface ExchangeInteractor {

    fun getLastExchangeCoins(): Pair<Coin, Coin>

    fun exchange(exchangeModel: ExchangeModel): Boolean

    fun getExchangeRate(coin1: Coin, coin2: Coin): Double

    fun swap()
}