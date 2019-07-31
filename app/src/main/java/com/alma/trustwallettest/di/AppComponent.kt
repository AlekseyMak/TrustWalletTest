package com.alma.trustwallettest.di

import android.app.Application
import com.alma.trustwallettest.TrustWalletTestApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class,
        MainActivityModule::class,
        ViewModelModule::class,
        InteractorModule::class,
        RepositoryModule::class]
)
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(app: TrustWalletTestApp)

    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}