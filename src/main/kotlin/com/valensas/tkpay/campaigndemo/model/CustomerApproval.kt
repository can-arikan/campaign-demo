package com.valensas.tkpay.campaigndemo.model

import java.util.UUID

data class CustomerApproval(
    val enrollmentId: UUID,
    val status: Status,
) {
    enum class Status {
        Approved,
        Rejected,
    }
}
