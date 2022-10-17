package interview.client.impl

import interview.client.PaymentsClient
import interview.model.Payment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Integer.min
import kotlin.random.Random

class PaymentsClientImpl : PaymentsClient {
    override suspend fun getPayments(limit: Int, offset: Int): List<Payment> = withContext(Dispatchers.IO) {
        val page = PAYMENTS.subList(offset, min(offset + limit, PAYMENTS.size))
        println("Got page limit=$limit offset=$offset $page")
        page
    }

    companion object {
        private val PAYMENTS = (1..10000).map { id ->
            Payment(
                paymentId = id.toString(),
                userId = Random.nextInt(10).toString() ?: "1",
                amount = Random.nextLong(1000, 5000)
            )
        }
    }
}