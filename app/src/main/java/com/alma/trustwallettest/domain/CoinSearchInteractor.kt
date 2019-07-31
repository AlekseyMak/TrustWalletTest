package com.alma.trustwallettest.domain

import com.alma.trustwallettest.presentation.search.CoinDirection

interface CoinSearchInteractor {

    fun getAvailableCoins(checkedCoinIndex: Int): List<Coin>

    fun checkCoin(coin: Coin, coinDirection: CoinDirection)
}