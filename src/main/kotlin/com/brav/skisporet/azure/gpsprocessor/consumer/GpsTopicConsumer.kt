package com.brav.skisporet.azure.gpsprocessor.consumer

import com.azure.messaging.servicebus.*

class GpsTopicConsumer(private val CONNECTION_STRING: String, private val TOPIC_NAME: String, private val SUBSCRIPTION_NAME: String) {
    fun start() {
        val processorClient: ServiceBusProcessorClient = ServiceBusClientBuilder()
            .connectionString(CONNECTION_STRING)
            .processor()
            .topicName(TOPIC_NAME)
            .subscriptionName(SUBSCRIPTION_NAME)
            .processMessage { receivedMessageContext -> onMessage(receivedMessageContext) }
            .processError { errorContext -> onError(errorContext) }
            .buildProcessorClient()

        println("Starting the topic processor")
        processorClient.start()
    }

    private fun onMessage(context: ServiceBusReceivedMessageContext) {
        println("Processing topic message. Sequence #: ${context.message.sequenceNumber}. Contents: ${context.message.body}")
    }

    private fun onError(context: ServiceBusErrorContext) {
        if (context.exception is ServiceBusException) {
            val exception = context.exception as ServiceBusException
            println("Error source: ${context.errorSource}, reason ${exception.reason}")
        } else {
            println("Error occurred: ${context.exception}")
        }
    }

}