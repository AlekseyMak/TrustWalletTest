package com.alma.trustwallettest.presentation.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alma.trustwallettest.domain.Coin
import com.alma.trustwallettest.domain.CoinSearchInteractor
import javax.inject.Inject

enum class SearchState {
    COIN_SET
}

class CoinSearchViewModel @Inject constructor(
    private val coinSearchInteractor: CoinSearchInteractor
) : ViewModel() {

    val searchModelLiveData = MutableLiveData<List<Coin>>()
    val stateLiveData = MutableLiveData<SearchState>()

    fun getAvailableCoins(checkedCoinIndex: Int) {
        searchModelLiveData.postValue(
            coinSearchInteractor.getAvailableCoins(checkedCoinIndex)
        )
    }

    fun setCoin(coin: Coin, coinDirection: CoinDirection) {
        coinSearchInteractor.checkCoin(coin, coinDirection)
        stateLiveData.postValue(SearchState.COIN_SET)
    }
}