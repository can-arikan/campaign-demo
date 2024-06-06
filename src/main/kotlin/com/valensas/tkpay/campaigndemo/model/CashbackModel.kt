package com.valensas.tkpay.campaigndemo.model

import java.math.BigDecimal

data class CashbackModel(
    val ratio: BigDecimal,
    val fixAmount: BigDecimal,
    val rules: List<TransactionRule>,
)
