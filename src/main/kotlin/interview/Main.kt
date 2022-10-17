package interview

import interview.client.impl.BackOfficeClientImpl
import interview.client.impl.CrmClientImpl
import interview.client.impl.PaymentsClientImpl
import interview.dao.UsersDaoImpl
import interview.kafka.KafkaUserProducerImpl
import interview.model.User.Companion.USERS
import interview.service.BackOfficeService
import interview.service.PaymentsService
import interview.service.UsersService
import kotlinx.coroutines.runBlocking

fun main() {
    val backOfficeClient = BackOfficeClientImpl()
    val crmClient = CrmClientImpl()
    val paymentsClient = PaymentsClientImpl()

    val usersDao = UsersDaoImpl()
    val kafkaUserProducer = KafkaUserProducerImpl()

    val backOfficeService = BackOfficeService(backOfficeClient)
    val paymentsService = PaymentsService(paymentsClient)
    val usersService = UsersService(usersDao, crmClient, kafkaUserProducer)

    runBlocking { Program(usersService, paymentsService, backOfficeService).run(USERS.keys.toList()) }
}