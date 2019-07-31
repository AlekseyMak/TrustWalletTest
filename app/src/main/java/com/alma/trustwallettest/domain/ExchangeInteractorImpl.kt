package com.alma.trustwallettest.domain

import com.alma.trustwallettest.data.CoinRepository
import javax.inject.Inject
import kotlin.random.Random

class ExchangeInteractorImpl @Inject constructor(
    private val coinRepository: CoinRepository
): ExchangeInteractor {

    override fun swap() {
        val lastCoins = coinRepository.getLastUsedCoins()
        coinRepository.setLastUsedCoinExchangeFrom(lastCoins.second)
        coinRepository.setLastUsedCoinExchangeTo(lastCoins.first)
    }

    override fun getLastExchangeCoins(): Pair<Coin, Coin> {
        return coinRepository.getLastUsedCoins()
    }

    override fun exchange(exchangeModel: ExchangeModel): Boolean {
        return true
    }

    override fun getExchangeRate(coin1: Coin, coin2: Coin): Double {
        return Random.nextDouble(2.0)
    }
}