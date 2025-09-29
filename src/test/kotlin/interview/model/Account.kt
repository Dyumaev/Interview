package interview.model

import java.math.BigDecimal

data class Account(val id: String, val balance: BigDecimal?, val type: AccountType, val status: AccountStatus)

enum class AccountType {
    DEPOSIT,
    CREDIT,
    BUSINESS
}

enum class AccountStatus {
    ACTIVE,
    CLOSED,
    BLOCK,
    OVERDUE
}