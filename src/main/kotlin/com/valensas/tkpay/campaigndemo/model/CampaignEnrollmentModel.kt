package com.valensas.tkpay.campaigndemo.model

import java.math.BigDecimal
import java.util.UUID

data class CampaignEnrollmentModel(
    val id: UUID? = null,
    val customerId: String,
    val campaignId: UUID,
    val progress: BigDecimal,
    val rewardedCashback: BigDecimal? = null,
    val status: Status = Status.Waiting,
) {
    enum class Status {
        Waiting,
        Approved,
        Rejected,
    }
}
