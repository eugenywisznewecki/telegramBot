package bel.ink.telegrambot

import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.TelegramBotsApi
import org.telegram.telegrambots.api.methods.send.SendMessage
import org.telegram.telegrambots.api.objects.Update
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.exceptions.TelegramApiException
import org.telegram.telegrambots.exceptions.TelegramApiRequestException

class Bot : TelegramLongPollingBot() {


    override fun getBotToken() = TOKEN

    override fun getBotUsername() = "TOP30_bot"

    override fun onUpdateReceived(update: Update?) {

        val message = update?.message?.text
        message?.let {  sendMsq(update.message?.chatId.toString(), message)  }

    }

    fun sendMsq(chatID: String, s: String) {
        val sendMessage = SendMessage()
        sendMessage.apply {
            enableMarkdown(true)
            this.chatId = chatID
            text = s
        }

        try {
            execute(sendMessage)
        } catch (e: TelegramApiException) {
        }
    }


}