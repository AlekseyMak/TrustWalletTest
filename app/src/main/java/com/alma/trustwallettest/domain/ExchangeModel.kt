package com.alma.trustwallettest.domain

data class ExchangeModel(
    val coin1: Coin,
    val amount1: Double,
    val coin2: Coin
) {
}