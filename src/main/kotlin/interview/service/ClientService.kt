package interview.service

import interview.client.ClientServiceClient
import interview.dao.ClientDao
import interview.kafka.KafkaClientProducer
import interview.model.Client

class ClientService(
    private val clientDao: ClientDao,
    private val clientServiceClient: ClientServiceClient,
    private val kafkaClientProducer: KafkaClientProducer
) {

    // Раньше сервис ходил напрямую в базу с клиентами.
    // Теперь работа с клиентами была вынесена в отдельный сервис и клиента необходимо получать оттуда.
    // К сожалению, процесс миграции сложный, поэтому части клиентов в этом сервисе нет.
    // В случае если клиент не найден в сервисе, его надо поискать в старой базе.
    // Отвечать нужно по-прежнему быстро, поэтому необходимо одновременно проверять два источника.
    // Кроме того, чтобы-таки когда-то закончить миграцию, клиенты, которых нет в сервисе должны быть отправлены в кафку, чтобы сервис их когда-то разгреб.
    // Это не должно влиять на тайминги, поэтому писать нужно fire-and-forget.
    suspend fun getClient(id: String): Client = TODO()

}