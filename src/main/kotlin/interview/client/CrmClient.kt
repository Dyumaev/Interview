package interview.client

import interview.model.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future
import java.util.concurrent.CompletableFuture

interface CrmClient {
    suspend fun getUser(id: String): User?

    fun getUserJ(id: String): CompletableFuture<User?> =
        GlobalScope.future { getUser(id) }
}