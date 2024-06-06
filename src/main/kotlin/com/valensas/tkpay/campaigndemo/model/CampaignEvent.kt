package com.valensas.tkpay.campaigndemo.model

import java.time.Instant

data class CampaignEvent(
    val type: Type,
    val campaign: CampaignModel,
    val enrollment: CampaignEnrollmentModel? = null,
    val time: Instant = Instant.now(),
) {
    enum class Type {
        BudgetAlert,
        Redeem,
        OfferedBudgetAlert,
    }
}
