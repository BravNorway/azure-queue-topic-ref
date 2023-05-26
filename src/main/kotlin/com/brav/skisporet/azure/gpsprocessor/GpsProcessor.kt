package com.brav.skisporet.azure.gpsprocessor

import com.brav.skisporet.azure.gpsprocessor.consumer.GpsQueueConsumer
import com.brav.skisporet.azure.gpsprocessor.consumer.GpsTopicConsumer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GpsProcessor {

    companion object {
        private const val CONNECTION_STRING: String =
            "Endpoint=sb://skisporet-sb-mq.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=YafQkRwamsc+eWfJLWdasfa/kN9bA+3T0+ASbNbuygE="
        private const val QUEUE_NAME: String = "gps-data-queue"
        private const val TOPIC_NAME: String = "gps-data"
        private const val TOPIC_SUBSCRIPTION_NAME: String = "gps-data-topic"

        fun start(){
            println("Starting GpsProcessor...s");
//            GpsQueueConsumer(CONNECTION_STRING, QUEUE_NAME).start()
//            GpsTopicConsumer(CONNECTION_STRING, TOPIC_NAME, TOPIC_SUBSCRIPTION_NAME).start()
        }
    }
}

fun main(args: Array<String>) {
    runApplication<GpsProcessor>(*args)

    GpsProcessor.start()
}

