package interview.service

import interview.client.PaymentsClient
import interview.model.Payment

class PaymentsService(private val paymentsClient: PaymentsClient) {

    // Платежи нужно запросить из некоторого сервиса платежей.
    // Сервис не очень мощный и может упасть если запрашивать данные целиком,
    // поэтому нужно аккуратно обойти его по страницам.
    suspend fun getPayments(): List<Payment> = TODO()

}