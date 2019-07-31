package com.alma.trustwallettest.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alma.trustwallettest.base.TWViewModelFactory
import com.alma.trustwallettest.presentation.main.MainViewModel
import com.alma.trustwallettest.presentation.search.CoinSearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun provideMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CoinSearchViewModel::class)
    abstract fun provideTokenSearchViewModel(coinSearchViewModel: CoinSearchViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: TWViewModelFactory): ViewModelProvider.Factory
}