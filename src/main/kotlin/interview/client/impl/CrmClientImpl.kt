package interview.client.impl

import interview.client.CrmClient
import interview.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CrmClientImpl : CrmClient {
    override suspend fun getUser(id: String): User? = withContext(Dispatchers.IO) {
        val user = if (NO_USERS_IDS.contains(id)) null else User.USERS[id]
        println("Got user from crm $user")
        user
    }

    companion object {
        val NO_USERS_IDS = setOf("1", "3", "4")
    }
}