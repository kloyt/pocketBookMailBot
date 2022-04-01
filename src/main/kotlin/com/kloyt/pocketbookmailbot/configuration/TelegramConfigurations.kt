package com.kloyt.pocketbookmailbot.configuration

import com.kloyt.pocketbookmailbot.telegramBot.PocketBookMailBot
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.DefaultBotOptions
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook


@Configuration
class TelegramBotConfiguration(
        private val telegramConfig: TelegramConfigurations
) {

    @Bean
    fun defaultBotOptions(): DefaultBotOptions {
        return ApiContext.getInstance(DefaultBotOptions::class.java)
    }

    @Bean
    fun messageSource(): MessageSource {
        return ReloadableResourceBundleMessageSource().apply {
            setBasename("classpath:messages")
            setDefaultEncoding("UTF-8");
            setCacheSeconds(10)
        }
    }

}

@Component
@ConfigurationProperties(prefix = "telegram")
data class TelegramConfigurations(
        var webhookPath: String = "<webhook>",
        var botName: String = "<name>",
        var botToken: String = "<token>"
)