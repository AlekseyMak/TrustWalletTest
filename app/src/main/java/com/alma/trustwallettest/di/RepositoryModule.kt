package com.alma.trustwallettest.di

import com.alma.trustwallettest.data.CoinRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideCoinRepository(): CoinRepository {
        return CoinRepository()
    }
}