package com.alma.trustwallettest.di

import com.alma.trustwallettest.di.main.ExchangeModule
import com.alma.trustwallettest.di.search.TokenSearchModule
import com.alma.trustwallettest.presentation.main.MainFragment
import com.alma.trustwallettest.presentation.search.CoinSearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {


    @ContributesAndroidInjector(
        modules = [
            ViewModelModule::class,
            ExchangeModule::class
        ]
    )
    @FragmentScope
    abstract fun mainFragment(): MainFragment


    @ContributesAndroidInjector(
        modules = [
            ViewModelModule::class,
            TokenSearchModule::class
        ]
    )
    @FragmentScope
    abstract fun tokenSearchFragment(): CoinSearchFragment
}