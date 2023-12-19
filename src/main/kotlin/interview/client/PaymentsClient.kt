package interview.client

import interview.model.Payment

interface PaymentsClient {
    suspend fun getPayments(limit: Int, offset: Int): List<Payment>
}