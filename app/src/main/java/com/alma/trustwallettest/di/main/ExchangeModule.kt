package com.alma.trustwallettest.di.main

import com.alma.trustwallettest.data.CoinRepository
import com.alma.trustwallettest.domain.ExchangeInteractor
import com.alma.trustwallettest.domain.ExchangeInteractorImpl
import com.alma.trustwallettest.presentation.main.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class ExchangeModule {

    @Provides
    fun provideMainViewModel(exchangeInteractor: ExchangeInteractor): MainViewModel {
        return MainViewModel(exchangeInteractor)
    }

}