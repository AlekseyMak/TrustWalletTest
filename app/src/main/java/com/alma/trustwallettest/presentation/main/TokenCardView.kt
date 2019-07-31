package com.alma.trustwallettest.presentation.main

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.alma.trustwallettest.R
import com.alma.trustwallettest.domain.Coin
import kotlinx.android.synthetic.main.view_token_card.view.*

class TokenCardView(context: Context?, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {

    private var coin: Coin? = null
    private var skipAmountChange: Boolean = false

    init {
        LayoutInflater.from(context).inflate(R.layout.view_token_card, this, true)
        var titleId = R.string.you_pay

        context!!.theme.obtainStyledAttributes(
            attrs,
            R.styleable.TokenCard,
            0, 0
        ).apply {
            try {
                titleId = getResourceId(R.styleable.TokenCard_tc_title, R.string.you_pay)
            } finally {
                recycle()
            }
        }

        top_caption.text = context.getText(titleId)
        amount.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                v.post {
                    amount.setSelection(amount.getText().length)
                }
            }
        }
    }

    fun setCoin(coin: Coin) {
        this.coin = coin
        setAmount(0.0)
        coin_name.text = coin.name
        coin_img.setImageDrawable(context.getDrawable(coin.iconRes))
        funds.text = "${coin.amount} ${coin.name}"
    }

    fun getCoin(): Coin? {
        return coin
    }

    override fun setOnClickListener(l: OnClickListener?) {
        chevron.setOnClickListener(l)
        coin_name.setOnClickListener(l)
    }

    fun getAmount(): Double {
        return amount.getText().toString().toDoubleOrNull() ?: 0.0
    }

    fun setAmountChangeListener(listener: (newAmount: Double) -> Unit) {
        amount.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if (skipAmountChange) {
                    return
                }
                val newAmount = s.toString().toDoubleOrNull() ?: 0.0
                listener.invoke(newAmount)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })
    }

    fun setAmount(newAmount: Double) {
        skipAmountChange = true
        if (newAmount == 0.0) {
            amount.getText().clear()
        } else {
            amount.setText(newAmount.toString())
        }
        clearFocus()
        skipAmountChange = false
    }
}