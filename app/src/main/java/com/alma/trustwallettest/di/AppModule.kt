package com.alma.trustwallettest.di

import android.app.Application
import android.content.Context
import com.alma.trustwallettest.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(
    includes = [
        AndroidSupportInjectionModule::class]
)
abstract class AppModule() {

    @Binds
    abstract fun context(app: Application): Context


    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class
        ]
    )
    @ActivityScope
    abstract fun contributeMainActivity(): MainActivity


}