package interview.clients

import interview.model.Client

interface ClientsServiceHttpClient {
    fun getClient(phone: String): Client?
}