package com.alma.trustwallettest

import android.app.Activity
import android.app.Application
import com.alma.trustwallettest.di.AppComponent
import com.alma.trustwallettest.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class TrustWalletTestApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    private lateinit var appComponent: AppComponent

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

    protected fun createComponent() {
        appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)
    }

    override fun onCreate() {
        super.onCreate()
        createComponent()
    }

}