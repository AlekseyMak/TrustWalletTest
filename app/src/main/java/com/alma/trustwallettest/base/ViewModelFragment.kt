package com.alma.trustwallettest.base

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

abstract class ViewModelFragment<T : ViewModel>() : DaggerBaseFragment() {

    lateinit var viewModel: T

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = initViewModel()
    }

    abstract fun initViewModel(): T

}