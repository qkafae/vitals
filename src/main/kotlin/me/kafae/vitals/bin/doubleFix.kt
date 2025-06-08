package me.kafae.vitals.bin

import java.math.BigDecimal
import java.math.RoundingMode

fun Double.toFixed(decimals: Int): Double {
    return BigDecimal(this.toString())
        .setScale(decimals, RoundingMode.HALF_UP)
        .toDouble()
}