package com.kloyt.pocketbookmailbot.controller

import com.kloyt.pocketbookmailbot.telegramBot.PocketBookMailBot
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.telegram.telegrambots.meta.api.methods.BotApiMethod
import org.telegram.telegrambots.meta.api.objects.Update

@RestController
class WebHookController(
        private val pocketBookMailBot: PocketBookMailBot
) {
    @PostMapping
    fun update(@RequestBody update: Update): BotApiMethod<*> =
        pocketBookMailBot.onWebhookUpdateReceived(update)
}