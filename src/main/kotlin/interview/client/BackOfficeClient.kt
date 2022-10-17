package interview.client

import interview.model.Payment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future
import java.util.concurrent.CompletableFuture

interface BackOfficeClient {
    suspend fun sendPayments(userId: String, payments: List<Payment>): Unit

    fun sendPaymentsJ(userId: String, payments: List<Payment>): CompletableFuture<Unit> =
        GlobalScope.future { sendPayments(userId, payments) }
}