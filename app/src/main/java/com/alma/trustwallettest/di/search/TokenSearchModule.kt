package com.alma.trustwallettest.di.search

import com.alma.trustwallettest.domain.CoinSearchInteractor
import com.alma.trustwallettest.presentation.search.CoinSearchViewModel
import dagger.Module
import dagger.Provides

@Module
class TokenSearchModule {

    @Provides
    fun provideSearchViewModel(coinSearchInteractor: CoinSearchInteractor): CoinSearchViewModel {
        return CoinSearchViewModel(coinSearchInteractor)
    }

}