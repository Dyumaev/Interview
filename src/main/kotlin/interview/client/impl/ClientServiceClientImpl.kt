package interview.client.impl

import interview.client.ClientServiceClient
import interview.dao.ClientDao
import interview.model.Client
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ClientServiceClientImpl(private val clientDao: ClientDao) : ClientServiceClient {
    override suspend fun getClient(id: String): Client? = withContext(Dispatchers.IO) {
        val user = if (MISSING_CLIENTS_IDS.contains(id)) null else clientDao.getClient(id)
        println("Got user from crm $user")
        user
    }

    companion object {
        private val MISSING_CLIENTS_IDS = setOf("1", "3", "4")
    }
}