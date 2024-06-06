package com.valensas.tkpay.campaigndemo.controller

import com.valensas.tkpay.campaigndemo.kafka.KafkaProducer
import com.valensas.tkpay.campaigndemo.model.CustomerApproval
import com.valensas.tkpay.campaigndemo.model.RandomRequestModel
import com.valensas.tkpay.campaigndemo.model.RequestModel
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class KafkaProducerController(
    private val kafkaProducer: KafkaProducer,
) {
    @PostMapping("/produce")
    fun produceTransaction(
        @RequestBody request: RequestModel,
    ): Map<String, Any> = kafkaProducer.sendTransaction(request.id, request.amount, request.customerId, request.time, request.extra)

    @PostMapping("/produce/random")
    fun produceTransactionRandom(
        @RequestBody request: RandomRequestModel,
    ): Map<String, Any> = kafkaProducer.sendRandomTransaction(request.amount, request.extra)

    @PostMapping("/approve")
    fun approveEnrollment(
        @RequestBody request: CustomerApproval,
    ) = kafkaProducer.sendApproval(request)
}
