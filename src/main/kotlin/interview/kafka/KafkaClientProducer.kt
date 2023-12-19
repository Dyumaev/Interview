package interview.kafka

import interview.model.Client

interface KafkaClientProducer {
    suspend fun send(client: Client)
}