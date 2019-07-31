package com.alma.trustwallettest.presentation.search

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.alma.trustwallettest.R
import com.alma.trustwallettest.base.ViewModelFragment
import com.alma.trustwallettest.base.injectViewModel
import kotlinx.android.synthetic.main.fragment_coin_search.*

enum class CoinDirection {
    EXCHANGE_FROM,
    EXCHANGE_TO
}

class CoinSearchFragment : ViewModelFragment<CoinSearchViewModel>() {

    val args: CoinSearchFragmentArgs by navArgs()

    lateinit var adapter: CoinsAdapter

    override fun initViewModel(): CoinSearchViewModel {
        return injectViewModel()
    }

    override val layoutRes: Int
        get() = R.layout.fragment_coin_search

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.searchModelLiveData.observe(this, Observer {
            adapter.setItems(it)
        })

        viewModel.stateLiveData.observe(this, Observer {
            findNavController().popBackStack()
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        coins.layoutManager = LinearLayoutManager(requireContext())
        adapter = CoinsAdapter(requireContext()) {
            viewModel.setCoin(it, args.coinDirection)
        }
        coins.adapter = adapter

        viewModel.getAvailableCoins(args.checkedCoin)
    }

}