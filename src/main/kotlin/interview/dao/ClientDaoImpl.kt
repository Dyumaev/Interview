package interview.dao

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import interview.model.Client

class ClientDaoImpl : ClientDao {
    override suspend fun getClient(id: String): Client? = withContext(Dispatchers.IO) {
        val user = CLIENTS[id]
        println("Got client from db $user")
        user
    }

    companion object {
        private val CLIENTS = mapOf(
            Pair("1", Client.BadClient("1")),
            Pair("2", Client.GoodClient("2")),
            Pair("3", Client.GoodClient("3")),
            Pair("4", Client.GoodClient("4")),
            Pair("5", Client.GoodClient("5")),
            Pair("6", Client.GoodClient("6")),
            Pair("7", Client.GoodClient("7")),
            Pair("8", Client.BadClient("8")),
            Pair("9", Client.GoodClient("9")),
            Pair("10", Client.GoodClient("10"))
        )
    }
}