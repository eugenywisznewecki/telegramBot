package bel.ink.telegrambot

import org.telegram.telegrambots.api.methods.send.SendMessage
import org.telegram.telegrambots.api.objects.Update
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.exceptions.TelegramApiException

class Bot : TelegramLongPollingBot() {


    override fun getBotToken() = "331869684:AAEa48ZTt139jFon0UPG5ddleFwwBqzBbs0"

    override fun getBotUsername() = "TOP30_bot"

    override fun onUpdateReceived(update: Update) {

        val message = update.message.text
        sendMsq(update.message.chatId.toString(), message)


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