package interview.dao

import interview.model.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.future.future
import java.util.concurrent.CompletableFuture

@Deprecated("Use CrmClient instead")
interface UsersDao {
    suspend fun getUser(id: String): User?

    fun getUserJ(id: String): CompletableFuture<User?> = GlobalScope.future { getUser(id) }
}