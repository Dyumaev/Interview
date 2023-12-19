package interview.model

sealed interface Client {
    data class GoodClient(val id: String) : Client
    data class BadClient(val id: String) : Client
}