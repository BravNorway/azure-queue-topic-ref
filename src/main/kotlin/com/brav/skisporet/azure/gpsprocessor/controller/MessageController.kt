package com.brav.skisporet.azure.gpsprocessor.controller

import com.brav.skisporet.azure.gpsprocessor.producer.GpsQueueProducer
import com.brav.skisporet.azure.gpsprocessor.producer.GpsTopicProducer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController(
    private val gpsQueueProducer: GpsQueueProducer,
    private val gpsTopicProducer: GpsTopicProducer
                        ) {


    @GetMapping("/")
    fun test(): String {
        return "works!"
    }

    @PostMapping("/queue")
    fun produceToQueue(@RequestBody message: String): String {
        gpsQueueProducer.send(message)
        return "Published to queue: '$message'"
    }

    @PostMapping("/topic")
    fun produceToTopic(@RequestBody message: String): String {
        gpsTopicProducer.send(message)
        return "Published to topic: '$message'"
    }
}