package com.kloyt.pocketbookmailbot.mapper

import com.fasterxml.jackson.databind.ObjectMapper
import com.kloyt.pocketbookmailbot.domain.User
import org.springframework.core.convert.converter.Converter
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer


class UserToBytesConverter : Converter<User, ByteArray> {
    private var serializer: Jackson2JsonRedisSerializer<User> = Jackson2JsonRedisSerializer(User::class.java)

    init {
        serializer.setObjectMapper(ObjectMapper())
    }

    override fun convert(source: User): ByteArray = serializer.serialize(source)
}

class BytesToUserConverter : Converter<ByteArray, User> {
    private var serializer: Jackson2JsonRedisSerializer<User> = Jackson2JsonRedisSerializer(User::class.java)

    init {
        serializer.setObjectMapper(ObjectMapper())
    }

    override fun convert(value: ByteArray): User =
            serializer.deserialize(value)
}