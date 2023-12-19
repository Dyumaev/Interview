package interview.client

import interview.model.Payment

interface BackOfficeClient {
    suspend fun sendPayments(clientId: String, payments: List<Payment>)
}