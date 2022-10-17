package interview.kafka

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import interview.model.User

class KafkaUserProducerImpl : KafkaUserProducer {
    override suspend fun send(user: User): Unit = withContext(Dispatchers.IO) { println("Sent user to kafka") }
}