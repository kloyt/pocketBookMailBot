package com.kloyt.pocketbookmailbot.telegramBot.handler

import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.methods.BotApiMethod
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Message


@Component
class MessageHandler(
//        private val userService: UserService,
//        private val emailService: EmailService,
//        private val bookService: BookService,
) {

    fun answerMessage(message: Message): BotApiMethod<*> {
        val chatId = message.from.id
        return SendMessage(chatId.toString(), "text")
    }
}