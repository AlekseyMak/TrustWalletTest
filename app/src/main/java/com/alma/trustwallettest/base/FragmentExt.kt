package com.alma.trustwallettest.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

inline fun <reified T : ViewModel> ViewModelFragment<T>.injectViewModel(): T {
    return ViewModelProviders.of(this, viewModelFactory)[T::class.java]
}