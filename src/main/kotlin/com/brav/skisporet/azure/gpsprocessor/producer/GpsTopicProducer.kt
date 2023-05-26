package com.brav.skisporet.azure.gpsprocessor.producer

import com.azure.messaging.servicebus.ServiceBusClientBuilder
import com.azure.messaging.servicebus.ServiceBusMessage
import com.azure.messaging.servicebus.ServiceBusSenderClient
import org.springframework.stereotype.Component

private const val CONNECTION_STRING: String =
    "Endpoint=sb://skisporet-sb-mq.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=YafQkRwamsc+eWfJLWdasfa/kN9bA+3T0+ASbNbuygE="
private const val TOPIC_NAME: String = "gps-data"

@Component
class GpsTopicProducer {
    private var senderClient: ServiceBusSenderClient = ServiceBusClientBuilder()
        .connectionString(CONNECTION_STRING)
        .sender()
        .topicName(TOPIC_NAME)
        .buildClient()

    fun send(message: String) {
        println("Sending message to topic")
        senderClient.sendMessage(ServiceBusMessage(message))
    }
}