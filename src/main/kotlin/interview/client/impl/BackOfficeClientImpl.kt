package interview.client.impl

import interview.client.BackOfficeClient
import interview.model.Payment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BackOfficeClientImpl : BackOfficeClient {
    override suspend fun sendPayments(clientId: String, payments: List<Payment>) = withContext(Dispatchers.IO) {
        println("Sent payment $clientId $payments")
    }
}