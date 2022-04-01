package com.kloyt.pocketbookmailbot.domain

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("user")
data class User(
        @Id
        val telegramId: Long,

        val email: String
)
