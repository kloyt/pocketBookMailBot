package com.kloyt.pocketbookmailbot.telegramBot.handler

import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.methods.BotApiMethod
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.CallbackQuery

@Component
class CallbackQueryHandler(
//        private val userService: UserService,
//        private val emailService: EmailService,
//        private val bookService: BookService,
){

    fun processCallbackQuery(buttonQuery: CallbackQuery): BotApiMethod<*> {
        return SendMessage("123", "123")
    }
}