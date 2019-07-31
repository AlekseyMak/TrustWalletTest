package com.alma.trustwallettest.domain

import androidx.annotation.DrawableRes
import com.alma.trustwallettest.R
import kotlin.math.roundToLong
import kotlin.random.Random

data class Coin(
    val id: Int,
    val name: String,
    @DrawableRes
    val iconRes: Int,
    val amount: Double
) {

    constructor(id: Int, name: String): this(
        id,
        name,
        if (id % 2 == 0) R.drawable.ic_coin1 else R.drawable.ic_coin2,
        (Random.nextDouble(100.0) * 100000).roundToLong() / 100000.0
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Coin

        return other.id == this.id
    }

    override fun hashCode(): Int {
        return id
    }

    override fun toString(): String {
        return "$id: $amount $name"
    }
}