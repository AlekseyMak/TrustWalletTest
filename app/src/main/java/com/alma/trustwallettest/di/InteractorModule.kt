package com.alma.trustwallettest.di

import com.alma.trustwallettest.data.CoinRepository
import com.alma.trustwallettest.domain.CoinSearchInteractor
import com.alma.trustwallettest.domain.CoinSearchInteractorImpl
import com.alma.trustwallettest.domain.ExchangeInteractor
import com.alma.trustwallettest.domain.ExchangeInteractorImpl
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

    @Provides
    fun provideExchangeInteractor(coinRepository: CoinRepository): ExchangeInteractor {
        return ExchangeInteractorImpl(coinRepository)
    }

    @Provides
    fun provideCoinSearchInteractor(coinRepository: CoinRepository): CoinSearchInteractor {
        return CoinSearchInteractorImpl(coinRepository)
    }
}