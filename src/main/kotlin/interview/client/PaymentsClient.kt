package interview.client

import interview.model.Payment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future
import java.util.concurrent.CompletableFuture

interface PaymentsClient {
    suspend fun getPayments(limit: Int, offset: Int): List<Payment>

    fun getPaymentsJ(limit: Int, offset: Int): CompletableFuture<List<Payment>> =
        GlobalScope.future { getPayments(limit, offset) }
}