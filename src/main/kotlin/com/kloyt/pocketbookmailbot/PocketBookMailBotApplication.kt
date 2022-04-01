package com.kloyt.pocketbookmailbot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PocketBookMailBotApplication

fun main(args: Array<String>) {
    runApplication<PocketBookMailBotApplication>(*args)
}
