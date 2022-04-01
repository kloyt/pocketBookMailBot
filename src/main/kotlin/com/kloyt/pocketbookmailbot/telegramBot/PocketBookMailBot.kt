package com.kloyt.pocketbookmailbot.telegramBot

import org.telegram.telegrambots.meta.api.methods.BotApiMethod
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook
import org.telegram.telegrambots.meta.api.objects.Update


class PocketBookMailBot(
        val botPath: String?,
        val botUsername: String?,
        val botToken: String?,

        val messageHandler: MessageHandler,
        val callbackQueryHandler: CallbackQueryHandler
) {


    fun PocketBookMailBot(setWebhook: SetWebhook?, messageHandler: MessageHandler?, callbackQueryHandler: CallbackQueryHandler?) {
        super(setWebhook)
        this.messageHandler = messageHandler
        this.callbackQueryHandler = callbackQueryHandler
    }

    fun onWebhookUpdateReceived(update: Update): BotApiMethod<*>? {
        return try {
            handleUpdate(update)
        } catch (e: IllegalArgumentException) {
            SendMessage(update.message.chatId.toString(),
                    BotMessageEnum.EXCEPTION_ILLEGAL_MESSAGE.getMessage())
        } catch (e: Exception) {
            SendMessage(update.message.chatId.toString(),
                    BotMessageEnum.EXCEPTION_WHAT_THE_FUCK.getMessage())
        }
    }

}