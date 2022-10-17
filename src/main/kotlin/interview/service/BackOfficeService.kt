package interview.service

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import interview.client.BackOfficeClient
import interview.model.Payment

class BackOfficeService(private val backOfficeClient: BackOfficeClient) {

    // Платежи нужно выгрузить в некоторый сервис для бэкофиса.
    // Он не очень надежен и требует бережного обращения, поэтому загрузку необходимо производить небольшими батчами.
    // К сожалению, сервис бэкофиса работает нормально только тогда когда данные грузятся в него батчами с одним пользователем,
    // поэтому батчи надо собрать по пользователю.
    suspend fun sendPayments(payments: List<Payment>): Unit = TODO()

}