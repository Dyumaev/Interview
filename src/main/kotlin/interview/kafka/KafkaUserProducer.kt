package interview.kafka

import interview.model.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future
import java.util.concurrent.CompletableFuture

interface KafkaUserProducer {
    suspend fun send(user: User): Unit
    fun sendJ(user: User): CompletableFuture<Unit> =
        GlobalScope.future { send(user) }
}