package com.kloyt.pocketbookmailbot.configuration

import com.kloyt.pocketbookmailbot.mapper.BytesToUserConverter
import com.kloyt.pocketbookmailbot.mapper.UserToBytesConverter
import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration.LettuceClientConfigurationBuilder
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.convert.RedisCustomConversions
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer


@Configuration
@EnableRedisRepositories
class RedisConfigurations{
    @Bean
    fun lettuceClientConfigurationBuilderCustomizer(): LettuceClientConfigurationBuilderCustomizer? {
        return LettuceClientConfigurationBuilderCustomizer { clientConfigurationBuilder: LettuceClientConfigurationBuilder ->
            if (clientConfigurationBuilder.build().isUseSsl) {
                clientConfigurationBuilder.useSsl().disablePeerVerification()
            }
        }
    }

    @Bean
    fun redisTemplate(redisConnectionFactory: RedisConnectionFactory?): RedisTemplate<*, *>? {
        val template = RedisTemplate<ByteArray, ByteArray>()
        template.setConnectionFactory(redisConnectionFactory!!)
        template.keySerializer = StringRedisSerializer()
        template.valueSerializer = GenericJackson2JsonRedisSerializer()
        return template
    }

    @Bean
    fun redisCustomConversions(): RedisCustomConversions? =
        RedisCustomConversions(listOf(UserToBytesConverter(), BytesToUserConverter()))
}