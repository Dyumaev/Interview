package interview.dao

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import interview.model.User
import interview.model.User.Companion.USERS

class UsersDaoImpl : UsersDao {
    override suspend fun getUser(id: String): User? = withContext(Dispatchers.IO) {
        val user = USERS[id]
        println("Got user from db $user")
        user
    }
}