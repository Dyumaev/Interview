package interview.model

sealed interface User {
    data class NormalUser(val id: String) : User
    data class VipUser(val id: String) : User

    companion object {
        val USERS = mapOf(
            Pair("1", VipUser("1")),
            Pair("2", NormalUser("2")),
            Pair("3", NormalUser("3")),
            Pair("4", NormalUser("4")),
            Pair("5", NormalUser("5")),
            Pair("6", NormalUser("6")),
            Pair("7", NormalUser("7")),
            Pair("8", VipUser("8")),
            Pair("9", NormalUser("9")),
            Pair("10", NormalUser("10"))
        )
    }
}