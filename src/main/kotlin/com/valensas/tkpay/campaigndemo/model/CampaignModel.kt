package com.valensas.tkpay.campaigndemo.model

import java.math.BigDecimal
import java.time.Instant
import java.util.UUID

data class CampaignModel(
    val id: UUID?,
    val externalId: String,
    val enabled: Boolean,
    val description: String,
    val startDate: Instant,
    val endDate: Instant,
    val priority: Long,
    val repeatable: Boolean,
    val conditionType: ConditionType,
    val conditionAmount: BigDecimal,
    val cashback: CashbackModel,
    val extraCashback: CashbackModel?,
    val cashbackExpiryDate: Instant,
    val budget: BigDecimal,
    val consumedBudget: BigDecimal = BigDecimal.ZERO,
    val budgetAlertRatio: BigDecimal,
    val offeredBudget: BigDecimal,
    val consumedOfferedBudget: BigDecimal = BigDecimal.ZERO,
    val offeredBudgetAlertRatio: BigDecimal,
    val createdDate: Instant? = null,
) {
    enum class ConditionType {
        TransactionCount,
        TransactionAmountCumulative,
    }
}
