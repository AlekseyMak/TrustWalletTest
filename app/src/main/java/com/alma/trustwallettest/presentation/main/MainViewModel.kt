package com.alma.trustwallettest.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alma.trustwallettest.domain.Coin
import com.alma.trustwallettest.domain.ExchangeInteractor
import com.alma.trustwallettest.domain.ExchangeModel
import javax.inject.Inject

data class MainViewData(
    val coin1: Coin,
    val coin2: Coin,
    val exchangeRate: Double
) {

}

enum class ExchangeState {
    SUCCESS,
    FAIL
}

class MainViewModel @Inject constructor(
    private val exchangeInteractor: ExchangeInteractor
) : ViewModel() {

    val mainViewLiveData = MutableLiveData<MainViewData>()
    val exchangeStateLiveData = MutableLiveData<ExchangeState>()

    fun init() {
        val lastCoinPair = exchangeInteractor.getLastExchangeCoins()
        val exchangeRate = getRateForCoins(lastCoinPair.first, lastCoinPair.second)
        mainViewLiveData.postValue(MainViewData(lastCoinPair.first, lastCoinPair.second, exchangeRate))
    }

    fun swap() {
        exchangeInteractor.swap()
        init()
    }

    fun exchange(
        coin1: Coin?,
        coin2: Coin?,
        amount: Double
    ) {
        if (coin1 == null || coin2 == null) {
            exchangeStateLiveData.postValue(ExchangeState.FAIL)
        } else {
            if (exchangeInteractor.exchange(ExchangeModel(coin1, amount, coin2))) {
                exchangeStateLiveData.postValue(ExchangeState.SUCCESS)
            }
        }
    }

    private fun getRateForCoins(coin1: Coin, coin2: Coin): Double {
        return exchangeInteractor.getExchangeRate(coin1, coin2)
    }
}