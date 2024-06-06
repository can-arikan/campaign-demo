package com.valensas.tkpay.campaigndemo.model

import java.math.BigDecimal
import java.time.Instant
import java.util.UUID

data class RequestModel(
    val id: UUID = UUID.randomUUID(),
    val amount: BigDecimal,
    val customerId: UUID,
    val time: Instant = Instant.now(),
    val extra: Map<String, Any> = emptyMap(),
)
