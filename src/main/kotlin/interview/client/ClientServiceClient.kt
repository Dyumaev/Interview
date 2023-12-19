package interview.client

import interview.model.Client

interface ClientServiceClient {
    suspend fun getClient(id: String): Client?
}