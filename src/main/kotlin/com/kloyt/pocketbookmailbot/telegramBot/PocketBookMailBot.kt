package com.kloyt.pocketbookmailbot.telegramBot

import com.kloyt.pocketbookmailbot.configuration.TelegramConfigurations
import com.kloyt.pocketbookmailbot.telegramBot.handler.CallbackQueryHandler
import com.kloyt.pocketbookmailbot.telegramBot.handler.MessageHandler
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.telegram.telegrambots.bots.TelegramWebhookBot
import org.telegram.telegrambots.meta.api.methods.BotApiMethod
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

@Component
class PocketBookMailBot(
        private val messageHandler: MessageHandler,
        private val callbackQueryHandler: CallbackQueryHandler,
        private val telegramConfigurations: TelegramConfigurations
): TelegramWebhookBot() {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java.enclosingClass)
    }

    override fun onWebhookUpdateReceived(update: Update): BotApiMethod<*> {
        return SendMessage(update.message.from.id .toString(), "привет")
    }

    override fun getBotToken(): String =
            telegramConfigurations.botToken

    override fun getBotUsername(): String =
            telegramConfigurations.botName

    override fun getBotPath(): String =
            telegramConfigurations.webhookPath

}