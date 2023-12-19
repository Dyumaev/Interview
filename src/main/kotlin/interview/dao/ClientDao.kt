package interview.dao

import interview.model.Client

@Deprecated("Use CrmClient instead")
interface ClientDao {
    suspend fun getClient(id: String): Client?
}