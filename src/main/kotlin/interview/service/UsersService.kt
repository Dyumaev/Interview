package interview.service

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import interview.client.CrmClient
import interview.dao.UsersDao
import interview.kafka.KafkaUserProducer
import interview.model.User

class UsersService(
    private val usersDao: UsersDao,
    private val crmClient: CrmClient,
    private val kafkaUserProducer: KafkaUserProducer
) {

    // Раньше сервис ходил напрямую в базу с пользователями.
    // Теперь работа с пользователями была вынесена в отдельный сервис и пользователя необходимо получать оттуда.
    // К сожалению, процесс миграции сложный, поэтому части пользователей в этом сервисе нет.
    // В случае если пользователь не найден в срм, его надо поискать в старой базе.
    // Отвечать нужно по-прежнему быстро, поэтому необходимо одновременно проверять два источника.
    // Кроме того, чтобы таки когда-то закончить миграцию, пользователи, которых нет в crm должны быть отправлены в кафку, чтобы crm их быстро разгреб.
    // Это не должно влиять на тайминги, поэтому писать нужно fire-and-forget.
    // Follow-up: расхождения нужно логировать и писать в метрики (зажигаем алерт, например)
    // Follow-up: предположим, что в методе намешана еще много дополнительной логи и добавление сюда всякой "диагностики" мешает читаемости кода.
    // Что можно сделать чтобы разделить логирование, метрики и бизнес-логику?
    suspend fun getUser(id: String): User = TODO()

}