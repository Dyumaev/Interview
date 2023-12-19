package interview.kafka

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import interview.model.Client

class KafkaClientProducerImpl : KafkaClientProducer {
    override suspend fun send(client: Client): Unit = withContext(Dispatchers.IO) { println("Sent client to kafka") }
}