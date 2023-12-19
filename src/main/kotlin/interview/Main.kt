package interview

import interview.client.impl.BackOfficeClientImpl
import interview.client.impl.ClientServiceClientImpl
import interview.client.impl.PaymentsClientImpl
import interview.config.AppConfig
import interview.dao.ClientDaoImpl
import interview.kafka.KafkaClientProducerImpl
import interview.service.BackOfficeService
import interview.service.PaymentsService
import interview.service.ClientService
import kotlinx.coroutines.*
import kotlin.time.Duration

fun main() {
    val config = AppConfig((0..10).toList().map { it.toString() }, 3000)

    val clientDao = ClientDaoImpl()

    val backOfficeClient = BackOfficeClientImpl()
    val crmClient = ClientServiceClientImpl(clientDao)
    val paymentsClient = PaymentsClientImpl()

    val kafkaUserProducer = KafkaClientProducerImpl()

    val backOfficeService = BackOfficeService(backOfficeClient)
    val paymentsService = PaymentsService(paymentsClient)
    val clientService = ClientService(clientDao, crmClient, kafkaUserProducer)

    val server = routes(clientService)
    jobs(config, clientService, paymentsService, backOfficeService)

    runBlocking { server.join() }
}

@OptIn(DelicateCoroutinesApi::class)
fun routes(clientService: ClientService): Job =
    GlobalScope.launch {
        delay(Duration.INFINITE)
    }

// 1. Достать клиентов по ид из конфига. Их может быть много
// 2. Достать платежи по хорошим клиентам
// 3. Отправить в бекофис платежи плохих клиентов и хороших, у которых сумма платежей превышает лимит из конфига
// 4. Джоба должна выполняться в фоне и ее ошибки не должны убивать приложение
fun jobs(
    config: AppConfig,
    clientService: ClientService,
    paymentsService: PaymentsService,
    backOfficeService: BackOfficeService
) {
    println("Starting jobs")
    println("Finished jobs")
}