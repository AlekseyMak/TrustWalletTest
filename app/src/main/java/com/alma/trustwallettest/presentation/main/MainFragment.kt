package com.alma.trustwallettest.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.alma.trustwallettest.R
import com.alma.trustwallettest.base.ViewModelFragment
import com.alma.trustwallettest.base.injectViewModel
import com.alma.trustwallettest.domain.Coin
import com.alma.trustwallettest.presentation.search.CoinDirection
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : ViewModelFragment<MainViewModel>() {

    private var exchangeRate: Double = 0.0

    override fun initViewModel(): MainViewModel {
        return injectViewModel()
    }

    override val layoutRes: Int
        get() = R.layout.fragment_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.mainViewLiveData.observe(this, Observer {
            coin_one.setCoin(it.coin1)
            coin_two.setCoin(it.coin2)

            this.exchangeRate = it.exchangeRate

            rate.text = "1 ${it.coin1.name} ~ ${it.exchangeRate} ${it.coin2.name}"
            validateExchange()
        })

        viewModel.exchangeStateLiveData.observe(this, Observer {
            if (it == ExchangeState.SUCCESS) {
                coin_one.setAmount(0.0)
                coin_two.setAmount(0.0)
                Toast.makeText(requireContext(), "Exchange successful!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        coin_one.setOnClickListener {
            navigateToCoinSearch(coin_two.getCoin(), CoinDirection.EXCHANGE_FROM)
        }

        coin_two.setOnClickListener {
            navigateToCoinSearch(coin_one.getCoin(), CoinDirection.EXCHANGE_TO)
        }

        coin_one.setAmountChangeListener {
            coin_two.setAmount(it * exchangeRate)
            validateExchange()
        }
        coin_two.setAmountChangeListener {
            coin_one.setAmount(it / exchangeRate)
            validateExchange()
        }

        button_exchange.setOnClickListener {
            viewModel.exchange(coin_one.getCoin(), coin_two.getCoin(), coin_one.getAmount())
        }

        swap_coins.setOnClickListener {
            viewModel.swap()
        }

        viewModel.init()
    }

    private fun navigateToCoinSearch(checkedCoin: Coin?, coinDirection: CoinDirection) {
        if (checkedCoin == null) {
            Log.e("Main", "No coin")
            return
        }
        val action = MainFragmentDirections
            .actionMainFragmentToTokenSearchFragment(
                checkedCoin.id,
                coinDirection
            )
        findNavController().navigate(action)
    }

    private fun validateExchange() {
        checkAmount(coin_one.getAmount(), coin_one.getCoin())
        checkAmount(coin_two.getAmount(), coin_two.getCoin())
    }

    private fun checkAmount(amount: Double, coin: Coin?) {
        if (coin == null) {
            disableExchange()
        } else {
            if (amount == 0.0 || amount > coin.amount) {
                disableExchange()
            } else {
                enableExchange()
            }
        }
    }

    private fun disableExchange() {
        button_exchange.isEnabled = false
    }

    private fun enableExchange() {
        button_exchange.isEnabled = true
    }
}