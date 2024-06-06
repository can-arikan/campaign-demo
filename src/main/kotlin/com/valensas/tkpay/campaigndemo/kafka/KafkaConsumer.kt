package com.valensas.tkpay.campaigndemo.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import com.valensas.tkpay.campaigndemo.model.CampaignEvent
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumer(
    private val objectMapper: ObjectMapper,
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    @KafkaListener(topics = ["\${spring.kafka.topics.events}"])
    fun consumeMessages(event: String) {
        val serializedEvent = objectMapper.readValue(event, CampaignEvent::class.java)
        logger.info("Event type: ${serializedEvent.type}")
        logger.info("Campaign id: ${serializedEvent.campaign.externalId}")
        logger.info("Campaign description: ${serializedEvent.campaign.description}")
        logger.info("Campaign remaining offered budget: ${serializedEvent.campaign.offeredBudget - serializedEvent.campaign.consumedOfferedBudget}")
        logger.info("Campaign remaining budget: ${serializedEvent.campaign.budget - serializedEvent.campaign.consumedBudget}")
        logger.info("Customer id: ${serializedEvent.enrollment?.customerId}")
        logger.info("Customer rewarded cashback: ${serializedEvent.enrollment?.rewardedCashback}")
        logger.info("Enrollment id: ${serializedEvent.enrollment?.id}")
        logger.info(" ")
    }
}
