package interview.clients

import interview.model.Account
import interview.model.Client

interface AccountsServiceHttpClient {
    fun getAccounts(clientId: Client): List<Account>
}