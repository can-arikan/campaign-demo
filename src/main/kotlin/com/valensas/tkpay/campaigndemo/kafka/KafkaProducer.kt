package com.valensas.tkpay.campaigndemo.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.convertValue
import com.valensas.tkpay.campaigndemo.model.CustomerApproval
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.Instant
import java.util.UUID

@Service
class KafkaProducer(
    @Value("\${spring.kafka.topics.transaction}")
    private val topic: String,
    @Value("\${spring.kafka.topics.approval-event}")
    private val approvalTopic: String,
    private val kafka: KafkaTemplate<String, Map<String, Any>>,
    private val objectMapper: ObjectMapper,
) {
    fun trialTransaction(
        id: UUID = UUID.randomUUID(),
        amount: BigDecimal,
        customerId: UUID = UUID.randomUUID(),
        time: Instant = Instant.now(),
        extra: Map<String, Any>? = null,
    ): Map<String, Any> =
        mapOf(
            "id" to id,
            "amount" to amount,
            "customerId" to customerId,
            "time" to time,
        ).let {
            extra?.let { ex ->
                return it + ex
            }
            it
        }

    fun sendRandomTransaction(
        amount: BigDecimal,
        extra: Map<String, Any>? = null,
    ): Map<String, Any> {
        val testData = trialTransaction(amount = amount, extra = extra)
        kafka.send(topic, testData)
        return testData
    }

    fun sendTransaction(
        id: UUID,
        amount: BigDecimal,
        customerId: UUID,
        time: Instant,
        extra: Map<String, Any>? = null,
    ): Map<String, Any> {
        val testData =
            trialTransaction(
                id,
                amount,
                customerId,
                time,
                extra,
            )
        kafka.send(topic, testData)
        return testData
    }

    fun sendApproval(approval: CustomerApproval) {
        kafka.send(approvalTopic, objectMapper.convertValue<Map<String, Any>>(approval))
    }
}
