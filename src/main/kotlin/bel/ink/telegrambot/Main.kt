package bel.ink.telegrambot

import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.TelegramBotsApi
import org.telegram.telegrambots.exceptions.TelegramApiRequestException


fun main(args: Array<String>) {
    ApiContextInitializer.init()

    val telegramBotsApi = TelegramBotsApi()

    try {
        telegramBotsApi.registerBot(Bot())
    } catch (e: TelegramApiRequestException) {
        e.printStackTrace()
    }
}

