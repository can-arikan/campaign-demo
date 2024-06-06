package com.valensas.tkpay.campaigndemo.util

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.jayway.jsonpath.JsonPath

class JsonPathSerializer : JsonSerializer<JsonPath>() {
    override fun serialize(
        value: JsonPath,
        gen: JsonGenerator,
        arg2: SerializerProvider,
    ) = gen.writeString(value.path)
}

class JsonPathDeserializer : JsonDeserializer<JsonPath>() {
    override fun deserialize(
        jp: JsonParser,
        ctxt: DeserializationContext?,
    ): JsonPath {
        if (jp.currentToken.equals(JsonToken.VALUE_STRING)) {
            val text = jp.text.toString()
            return JsonPath.compile(text)
        } else {
            throw JsonParseException("Could not parse JsonPath from JSON")
        }
    }
}
