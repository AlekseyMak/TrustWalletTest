package com.alma.trustwallettest.domain

import com.alma.trustwallettest.data.CoinRepository
import com.alma.trustwallettest.presentation.search.CoinDirection
import javax.inject.Inject

class CoinSearchInteractorImpl @Inject constructor(
    private val coinRepository: CoinRepository
) : CoinSearchInteractor {
    override fun getAvailableCoins(checkedCoinIndex: Int): List<Coin> {
        return coinRepository.getCoins().filter { it.id != checkedCoinIndex }
    }

    override fun checkCoin(coin: Coin, coinDirection: CoinDirection) {
        when (coinDirection) {
            CoinDirection.EXCHANGE_FROM -> coinRepository.setLastUsedCoinExchangeFrom(coin)
            CoinDirection.EXCHANGE_TO -> coinRepository.setLastUsedCoinExchangeTo(coin)
        }
    }
}