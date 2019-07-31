package com.alma.trustwallettest

import android.os.Bundle
import com.alma.trustwallettest.base.DaggerBaseActivity

class MainActivity : DaggerBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
