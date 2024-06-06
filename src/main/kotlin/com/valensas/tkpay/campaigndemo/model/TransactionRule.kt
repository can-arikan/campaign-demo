package com.valensas.tkpay.campaigndemo.model

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.jayway.jsonpath.JsonPath
import com.valensas.tkpay.campaigndemo.util.JsonPathDeserializer
import com.valensas.tkpay.campaigndemo.util.JsonPathSerializer

data class TransactionRule(
    @JsonSerialize(using = JsonPathSerializer::class)
    @JsonDeserialize(using = JsonPathDeserializer::class)
    val path: JsonPath,
    val operator: Operator,
    val value: Any,
    val type: Type,
) {
    enum class Type {
        String,
        Double,
        Date,
    }

    enum class Operator {
        Le,
        Lt,
        Eq,
        Ge,
        Gt,
        In,
    }
}
