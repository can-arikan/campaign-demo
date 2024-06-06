package com.valensas.tkpay.campaigndemo.model

import java.math.BigDecimal

data class RandomRequestModel(
    val amount: BigDecimal,
    val extra: Map<String, Any> = emptyMap(),
)
