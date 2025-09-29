package interview.test

import interview.clients.AccountsServiceHttpClient
import interview.clients.ClientsServiceHttpClient
import interview.generator.PhoneNumberGenerator

class Test(
    val accountsServiceHttpClient: AccountsServiceHttpClient,
    val clientsServiceHttpClient: ClientsServiceHttpClient,
    val phoneNumberGenerator: PhoneNumberGenerator,
) {

    fun someTest() {

    }

}