package com.alma.trustwallettest.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment

abstract class DaggerBaseFragment : DaggerFragment() {

    protected var rootView: View? = null

    protected abstract val layoutRes: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater!!.inflate(layoutRes, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onViewCreated(view, savedInstanceState)
    }
}