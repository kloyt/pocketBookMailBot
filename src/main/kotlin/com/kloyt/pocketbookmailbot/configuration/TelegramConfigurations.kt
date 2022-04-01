package com.kloyt.pocketbookmailbot.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "telegram")
data class TelegramConfigurations(
        var apiUrl: String = "<apiUrl>",
        var webhookPath: String = "<webhook>",
        var botName: String = "<name>",
        var botToken: String = "<token>"
)