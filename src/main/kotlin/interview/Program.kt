package interview

import kotlinx.coroutines.flow.*
import interview.model.User
import interview.service.BackOfficeService
import interview.service.PaymentsService
import interview.service.UsersService

class Program(
    private val usersService: UsersService,
    private val paymentsService: PaymentsService,
    private val backOfficeService: BackOfficeService
) {

    // 1. Достать пользователей по переданным ид
    // 2. Оставить тех кто действительно вип
    // 3. Достать платежи
    // 4. Отправить дальше только те, которые принадлежат не вип клиентам
    suspend fun run(maybeVipsIds: List<String>): Unit = TODO()

}